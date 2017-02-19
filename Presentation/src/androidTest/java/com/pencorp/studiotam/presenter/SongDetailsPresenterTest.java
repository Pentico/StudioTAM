package com.pencorp.studiotam.presenter;

import android.content.Context;
import android.test.AndroidTestCase;

import com.pencorp.domain.interactor.GetSong;
import com.pencorp.studiotam.View.SongDetailsView;
import com.pencorp.studiotam.mapper.SongModelDataMapper;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Subscriber;

import static org.mockito.Matchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by Tuane on 17/02/17.
 */

public class SongDetailsPresenterTest extends AndroidTestCase {

    private static final long FAKE_SONG_ID = 425;

    private SongDetailsPresenter songDetailsPresenter;

    @Mock
    private Context mockContext;
    @Mock
    private SongDetailsView mockSongDetailsView;
    @Mock
    private GetSong mockGetSong;
    @Mock
    private SongModelDataMapper mockSongModelDataMapper;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        songDetailsPresenter = new SongDetailsPresenter(mockGetSong,
                mockSongModelDataMapper);
        songDetailsPresenter.setView(mockSongDetailsView);
    }

    public  void  testSongDetailsPresenterInitialze() {
        given(mockSongDetailsView.context()).willReturn(mockContext);

        songDetailsPresenter.initialize();

        verify(mockSongDetailsView).hideRetry();
        verify(mockSongDetailsView).showLoading();
        verify(mockGetSong).execute(any(Subscriber.class));
    }
}
