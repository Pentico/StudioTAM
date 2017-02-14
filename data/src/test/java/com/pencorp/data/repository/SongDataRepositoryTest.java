package com.pencorp.data.repository;

import com.pencorp.data.ApplicationTestCase;
import com.pencorp.data.entity.SongEntity;
import com.pencorp.data.entity.mapper.SongEntityDataMapper;
import com.pencorp.data.repository.datasource.SongData.SongDataStore;
import com.pencorp.data.repository.datasource.SongData.SongDataStoreFactory;
import com.pencorp.domain.Song;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

/**
 * Created by Tuane on 9/02/17.
 */

public class SongDataRepositoryTest extends ApplicationTestCase {

    private static final long FAKE_SONG_ID = 586;

    private SongDataRepository songDataRepository;

    @Mock
    private SongDataStoreFactory mockSongDataStoreFactory;
    @Mock
    private SongEntityDataMapper mockSongEntityDataMapper;
    @Mock
    private SongDataStore mockSongDataStore;
    @Mock
    private SongEntity mockSongEntity;
    @Mock
    private Song mockSong;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        songDataRepository = new SongDataRepository(mockSongEntityDataMapper,
                mockSongDataStoreFactory);

        given(mockSongDataStoreFactory.create(anyInt())).willReturn(mockSongDataStore);
        given(mockSongDataStoreFactory.createDiskDataStore()).willReturn(mockSongDataStore);

    }

    @Test
    public void testGetSongsHappyCase() {
        List<SongEntity> songEntityList = new ArrayList<>();
        songEntityList.add(new SongEntity());
        given(mockSongDataStore.songEntityList()).willReturn(Observable.just(songEntityList));

        songDataRepository.songs();

        verify(mockSongDataStoreFactory).createDiskDataStore();
        verify(mockSongDataStore).songEntityList();
    }
}
