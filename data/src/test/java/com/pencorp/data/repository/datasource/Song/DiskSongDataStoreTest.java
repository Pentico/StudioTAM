package com.pencorp.data.repository.datasource.Song;

import com.pencorp.data.ApplicationTestCase;
import com.pencorp.data.cache.Song.SongCache;

import org.mockito.Mock;

/**
 * Created by Tuane on 9/02/17.
 */

public class DiskSongDataStoreTest extends ApplicationTestCase {

    private static final long FAKE_SONG_ID = 789;

    private DiskSongDataStoreTest diskSongDataStoreTest;

    @Mock
    private SongCache mockSongCache;
}
