package com.pencorp.domain.interactor;

import com.pencorp.domain.executor.PostExecutionThread;
import com.pencorp.domain.executor.ThreadExecutor;
import com.pencorp.domain.repository.SongRepository;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by Tuane on 15/02/17.
 */

public class GetSongTest {

    private static final long FAKE_SONG_ID = 934;
    private static final String FAKE_SONG_PATH = "sdcard/music/songs/";

    private GetSong getSong;

    @Mock
    private SongRepository mockSongRepository;
    @Mock
    private ThreadExecutor mockThreadExecutor;
    @Mock
    private PostExecutionThread mockPostExecutionThread;

    @Before
    public  void setUp() {
        MockitoAnnotations.initMocks(this);

    }
}
