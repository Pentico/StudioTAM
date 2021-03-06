package com.pencorp.domain.interactor;

import com.pencorp.domain.executor.PostExecutionThread;
import com.pencorp.domain.executor.ThreadExecutor;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Observable;
import rx.Subscriber;
import rx.observers.TestSubscriber;
import rx.schedulers.TestScheduler;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by Tuane on 15/02/17.
 */

public class UseCaseTest {

    private UseCaseTestClass useCase;

    @Mock
    private ThreadExecutor mockThreadExecutor;
    @Mock
    private PostExecutionThread mockPostExecutionThread;

    @Before
    public  void setUp() {
        MockitoAnnotations.initMocks(this);
        this.useCase = new UseCaseTestClass(mockThreadExecutor, mockPostExecutionThread);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testBuildCaseObservableReturnCorrectResult() {
        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
        TestScheduler testScheduler = new TestScheduler();
        given(mockPostExecutionThread.getScheduler()).willReturn(testScheduler);

        useCase.execute(testSubscriber);

        assertThat(testSubscriber.getOnNextEvents().size(), is(0));
    }

    @Test
    public void testSubscriptionWhenExecutingUseCase() {
        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();

        useCase.execute(testSubscriber);
        useCase.unsubscribe();

        MatcherAssert.assertThat(testSubscriber.isUnsubscribed(), is(true));
    }
    private static class UseCaseTestClass extends UseCase {

        protected UseCaseTestClass (
                ThreadExecutor threadExecutor,
                PostExecutionThread postExecutionThread) {
            super(threadExecutor, postExecutionThread);
        }

        @Override
        protected Observable buildUseCaseObservable() {
            return Observable.empty();
        }

        @Override public void execute(Subscriber UseCaseSubscriber) {
            super.execute(UseCaseSubscriber);
        }
    }
}
