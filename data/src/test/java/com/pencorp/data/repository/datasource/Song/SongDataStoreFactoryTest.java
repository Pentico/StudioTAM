package com.pencorp.data.repository.datasource.Song;

import com.pencorp.data.ApplicationTestCase;
import com.pencorp.data.cache.Song.SongCache;
import com.pencorp.data.repository.datasource.SongData.SongDataStoreFactory;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RuntimeEnvironment;

/**
 * Created by Tuane on 9/02/17.
 */

public class SongDataStoreFactoryTest extends ApplicationTestCase {

    private static final long FAKE_SONG_ID = 564;

    private SongDataStoreFactory songDataStoreFactory;

    @Mock
    SongCache mockSongCache;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        songDataStoreFactory =
                new SongDataStoreFactory(RuntimeEnvironment.application, mockSongCache);
    }

    @Test
    public void testCreateDiskDataStore() {

    }
}
