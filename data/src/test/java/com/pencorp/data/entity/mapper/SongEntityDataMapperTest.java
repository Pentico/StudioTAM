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
    private static final int FAKE_YEAR = 1994;
    private static final int FAKE_TRACK_NO = 2;
    private static final long FAKE_DURATION_MS = 5686;
    private static final String FAKE_GENRE = "Country";

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
        assertThat(song.getGenre(), is(FAKE_GENRE));
        assertThat(song.getDuration_ms(), is(FAKE_DURATION_MS));
        assertThat(song.getYear(), is(FAKE_YEAR));
        assertThat(song.getTrack_no(), is(FAKE_TRACK_NO));
    }

    private SongEntity createFakeSongEntity() {
        SongEntity songEntity = new SongEntity();
        songEntity.setAlbum(FAKE_ALBUM);
        songEntity.setTitle(FAKE_TITLE);
        songEntity.setArtist(FAKE_ARTIST);
        songEntity.setId(FAKE_SONG_ID);
        songEntity.setYear(FAKE_YEAR);
        songEntity.setDuration_ms(FAKE_DURATION_MS);
        songEntity.setTrack_no(FAKE_TRACK_NO);
        songEntity.setGenre(FAKE_GENRE);

        return songEntity;
    }
}
