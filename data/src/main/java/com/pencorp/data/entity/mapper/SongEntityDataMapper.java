package com.pencorp.data.entity.mapper;

import com.pencorp.data.entity.SongEntity;
import com.pencorp.domain.Song;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Tuane on 3/02/17.
 */


/**
 * Mapper class used to transform {@link SongEntity} (in the data layer) to {@link Song} in the
 * domain layer.
 */

@Singleton
public class SongEntityDataMapper {

    @Inject
    public SongEntityDataMapper() {}

    public Song transform(SongEntity songEntity) {
        Song song = null;
        if (songEntity != null) {
            song = new Song(songEntity.getId(), songEntity.getFilePath());
            song.setCoverUrl(songEntity.getCoverUrl());
            song.setYear(songEntity.getYear());
            song.setArtist(songEntity.getArtist());
            song.setAlbum(songEntity.getAlbum());
            song.setTrack_no(songEntity.getTrack_no());
            song.setDuration_ms(songEntity.getDuration_ms());

        }

        return song;
    }
}
