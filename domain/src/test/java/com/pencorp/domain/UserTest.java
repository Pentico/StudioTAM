package com.pencorp.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Tuane on 15/02/17.
 */

public class UserTest {

    private static final long FAKE_SONG_ID = 979;
    private static final String FAKE_SONG_PATH = "/sdcard/music/songs";

    private Song song;

    @Before
    public void setUp() {
        song = new Song(FAKE_SONG_ID, FAKE_SONG_PATH);
    }

    @Test
    public void testSongConstructorHappyCase() {
        long songId = song.getSongId();
        String songPath = song.getFilepath();

        assertThat(songId, is(FAKE_SONG_ID));
        assertThat(songPath, is(FAKE_SONG_PATH));
    }
}
