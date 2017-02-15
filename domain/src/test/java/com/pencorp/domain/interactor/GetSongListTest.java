package com.pencorp.domain.interactor;

import com.pencorp.domain.executor.PostExecutionThread;
import com.pencorp.domain.executor.ThreadExecutor;
import com.pencorp.domain.repository.SongRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by Tuane on 15/02/17.
 */

public class GetSongListTest {

    private GetSongList getSongList;

    @Mock
    private ThreadExecutor mockThreadExecutor;
    @Mock
    private PostExecutionThread mockPostExecutionThread;
    @Mock
    private SongRepository mockSongRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        getSongList = new GetSongList(mockThreadExecutor, mockPostExecutionThread,
                mockSongRepository);
    }

    @Test
    public void testGetSongListCaseObservableHappyCase() {
        getSongList.buildUseCaseObservable();
        verify(mockSongRepository).songs();
        verifyNoMoreInteractions(mockSongRepository);
        verifyZeroInteractions(mockThreadExecutor);
        verifyZeroInteractions(mockPostExecutionThread);
    }
}
