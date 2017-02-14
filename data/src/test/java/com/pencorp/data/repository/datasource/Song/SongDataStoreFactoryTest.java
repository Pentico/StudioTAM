package com.pencorp.data.repository.datasource.Song;

import com.pencorp.data.ApplicationTestCase;
import com.pencorp.data.cache.Song.SongCache;
import com.pencorp.data.repository.datasource.SongData.DiskSongDataStore;
import com.pencorp.data.repository.datasource.SongData.SongDataStore;
import com.pencorp.data.repository.datasource.SongData.SongDataStoreFactory;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RuntimeEnvironment;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

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
        given(mockSongCache.isCached(FAKE_SONG_ID)).willReturn(true);
        given(mockSongCache.isExpired()).willReturn(false);

        SongDataStore songDataStore = songDataStoreFactory.create(FAKE_SONG_ID);

        assertThat(songDataStore, is(notNullValue()));
        assertThat(songDataStore, is(instanceOf(DiskSongDataStore.class)));

        verify(mockSongCache).isCached(FAKE_SONG_ID);
        verify(mockSongCache).isExpired();
    }

    @Test
    public void testCreateDiskDataStore2() {
        /*given(mockSongCache.isExpired()).willReturn(true);
        given(mockSongCache.isCached(FAKE_SONG_ID)).willReturn(false);

        SongDataStore songDataStore = songDataStoreFactory.create(FAKE_SONG_ID);

        assertThat(songDataStore, is(notNullValue()));
        assertThat(songDataStore, is(instanceOf()))*/

    }
}
