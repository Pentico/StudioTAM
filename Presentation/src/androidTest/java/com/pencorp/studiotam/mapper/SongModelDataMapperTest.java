package com.pencorp.studiotam.mapper;

import com.pencorp.domain.Song;
import com.pencorp.studiotam.model.SongModel;

import junit.framework.TestCase;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by Tuane on 17/02/17.
 */

public class SongModelDataMapperTest extends TestCase {

    private static final long FAKE_SONG_ID = 532;
    private static final String FAKE_PATH = "sdCard/music";
    private static final String FAKE_TITLE = "Heroes";
    private static final String FAKE_ARTIST = "Jason";
    private static final String FAKE_ALBUM = "Power";
    private static final int FAKE_YEAR = 1994;
    private static final int FAKE_TRACK_NO = 2;
    private static final long FAKE_DURATION_MS = 5686;
    private static final String FAKE_GENRE = "Country";

    private SongModelDataMapper songModelDataMapper;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        songModelDataMapper = new SongModelDataMapper();
    } // EOF

    public  void testTransformSong() {

        Song song = createFakeSong();
        SongModel songModel = songModelDataMapper.transform(song);

        assertThat(songModel, is(instanceOf(SongModel.class)));
        assertThat(songModel.getDuration_ms(), is(FAKE_DURATION_MS));
        assertThat(songModel.getTrack_no(), is(FAKE_TRACK_NO));
        assertThat(songModel.getAlbum(), is(FAKE_ALBUM));
        assertThat(songModel.getGenre(), is(FAKE_GENRE));
        assertThat(songModel.getArtist(), is(FAKE_ARTIST));
        assertThat(songModel.getYear(), is(FAKE_YEAR));
        assertThat(songModel.getTitle(), is(FAKE_TITLE));

    }

    private Song createFakeSong() {
        Song song = new Song(FAKE_SONG_ID,FAKE_PATH);
        song.setGenre(FAKE_GENRE);
        song.setTitle(FAKE_TITLE);
        song.setYear(FAKE_YEAR);
        song.setAlbum(FAKE_ALBUM);
        song.setArtist(FAKE_ARTIST);
        song.setTrack_no(FAKE_TRACK_NO);
        song.setDuration_ms(FAKE_DURATION_MS);
    }
}
