package com.pencorp.data.repository.datasource.Song;

import com.pencorp.data.ApplicationTestCase;
import com.pencorp.data.cache.Song.SongCache;
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

    private DiskSongDataStore diskSongDataStore;

    @Mock
    private SongCache mockSongCache;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        diskSongDataStore = new DiskSongDataStore(mockSongCache);
    }

    /**
     * This should Fail Now cause I have implimented the Operation
     */
    @Test
    public void testGetSongEntityListUnsupported() {
        expectedException.expect(UnsupportedOperationException.class);
        diskSongDataStore.songEntityList();
    }

    @Test
    public void testGetSongEntityDetailsFromCache() {
        diskSongDataStore.songEntityDetails(FAKE_SONG_ID);
        verify(mockSongCache).get(FAKE_SONG_ID);
    }

    
}
