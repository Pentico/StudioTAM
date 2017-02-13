package com.pencorp.data.entity.mapper;

import com.pencorp.data.ApplicationTestCase;
import com.pencorp.data.entity.SongEntity;
import com.pencorp.domain.Song;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by Tuane on 9/02/17.
 */

public class SongEntityDataMapperTest extends ApplicationTestCase {

    private static final long FAKE_SONG_ID = 456;
    private static final String FAKE_TITLE = "Heroes";
    private static final String FAKE_ARTIST = "Jason";
    private static final String FAKE_ALBUM = "Power";

    private SongEntityDataMapper songEntityDataMapper;

    @Before
    public void setUp() throws Exception {
        songEntityDataMapper = new SongEntityDataMapper();
    }

    @Test
    public void testTrannsfromSongEntity() {
        SongEntity songEntity = createFakeSongEntity();
        Song song = songEntityDataMapper.transform(songEntity);

        assertThat(song, is(instanceOf(Song.class)));
        assertThat(song.getSongId(), is(FAKE_SONG_ID));
        assertThat(song.getArtist(), is(FAKE_ARTIST));
        assertThat(song.getAlbum(), is(FAKE_ALBUM));
        assertThat(song.getTitle(), is(FAKE_TITLE));
    }

    private SongEntity createFakeSongEntity() {
        SongEntity songEntity = new SongEntity();
        songEntity.setAlbum(FAKE_ALBUM);
        songEntity.setTitle(FAKE_TITLE);
        songEntity.setArtist(FAKE_ARTIST);
        songEntity.setId(FAKE_SONG_ID);

        return songEntity;
    }
}
