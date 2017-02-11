package com.pencorp.studiotam.mapper;

import com.pencorp.domain.Song;
import com.pencorp.studiotam.internal.di.PerActivity;
import com.pencorp.studiotam.model.SongModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

/**
 * Created by Tuane on 9/02/17.
 */

/**
 * Mapper class used to transform {@link Song} (in the domain layer) to
 * {@link SongModel} in the
 * presentation layer.
 */
@PerActivity
public class SongModelDataMapper {

    @Inject
    public SongModelDataMapper() {}

    public SongModel transform(Song song) {
        if (song == null){
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        SongModel songModel = new SongModel(song.getSongId());

        songModel.setAlbum(song.getAlbum());
        songModel.setYear(song.getYear());
        songModel.setGenre(song.getGenre());
        songModel.setArtist(song.getArtist());
        songModel.setTitle(song.getTitle());
        songModel.setTrack_no(song.getTrack_no());
        songModel.setDuration_ms(song.getDuration_ms());
        return songModel;
    }

    /**
     * Transform a Collection of {@link Song} into a Collection of {@link SongModel}.
     *
     * @param songCollection Objects to be transformed.
     * @return List of {@link SongModel}.
     */
    public Collection<SongModel> transform(Collection<Song> songCollection) {
        Collection<SongModel> songModelsCollection;

        if (songCollection != null && !songCollection.isEmpty()) {
            songModelsCollection = new ArrayList<>();
            for (Song song : songCollection) {
                songModelsCollection.add(transform(song));
            }
        } else {
            songModelsCollection = Collections.emptyList();
        }

        return songModelsCollection;
    }
}
