package com.pencorp.studiotam.test.presenter;

import android.content.Context;
import android.test.AndroidTestCase;

import com.pencorp.domain.interactor.GetSongList;
import com.pencorp.studiotam.View.SongListView;
import com.pencorp.studiotam.test.mapper.SongModelDataMapper;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Subscriber;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by Tuane on 17/02/17.
 */

public class SongListPresenterTest extends AndroidTestCase {

    private SongListPresenter songListPresenter;

    @Mock
    private Context mockContent;
    @Mock
    private SongListView mockSongListView;
    @Mock
    private GetSongList mockGetSongList;
    @Mock
    private SongModelDataMapper mockSongModelDataMapper;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);
        songListPresenter = new SongListPresenter(mockGetSongList, mockSongModelDataMapper);
        songListPresenter.setView(mockSongListView);
    } // EOF

    public void testSongListPresenterInitialize() {

        given(mockSongListView.context()).willReturn(mockContent);

        songListPresenter.initialize();

        verify(mockSongListView).hideRetry();
        verify(mockSongListView).showLoading();
        verify(mockGetSongList).execute(any(Subscriber.class));
    }
}
