package com.pencorp.domain.interactor;

/**
 * Created by Tuane on 3/02/17.
 */
/**
 * Default subscriber base class to be used whenever you
 * want default error handling.
 */
public class DefaultSubscriber<T> extends rx.Subscriber<T> {
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
