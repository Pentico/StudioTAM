package com.pencorp.data.repository.datasource.Song;

import com.pencorp.data.ApplicationTestCase;
import com.pencorp.data.cache.Song.SongCache;
import com.pencorp.data.media.RestSongsApi;
import com.pencorp.data.media.RestSongsApiImpl;
import com.pencorp.data.repository.datasource.SongData.DiskSongDataStore;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by Tuane on 9/02/17.
 */

public class DiskSongDataStoreTest extends ApplicationTestCase {

    private static final long FAKE_SONG_ID = 789;

    private DiskSongDataStore diskSongDataStore1;

    @Mock
    private SongCache mockSongCache;

    @Mock
    private RestSongsApiImpl mockRestSongsApi;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        diskSongDataStore1 = new DiskSongDataStore(mockSongCache, mockRestSongsApi);
    }

    /**
     * This should Fail Now cause I have implimented the Operation
     */
    @Test
    public void testGetSongEntityListUnsupported() {
        expectedException.expect(UnsupportedOperationException.class);
        diskSongDataStore1.songEntityList();
    }

    @Test
    public void testGetSongEntityDetailsFromCache() {
        diskSongDataStore1.songEntityDetails(FAKE_SONG_ID);
        verify(mockSongCache).get(FAKE_SONG_ID);
    }

    @Test
    public void testGetSongEntityListFromCache() {
        diskSongDataStore1.songEntityList();
        verify(mockSongCache).get();
    }
}
