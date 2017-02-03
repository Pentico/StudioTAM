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
public class SongEntityMapper {

    @Inject
    public SongEntityMapper() {}

    public Song transform(SongEntity songEntity) {
        Song song = null;
        if (songEntity != null) {
            song = new Song(songEntity.getUserId());
            song.setCoverUrl(songEntity.getCoverUrl());
            song.setYear(songEntity.getYear());
            song.setArtist(songEntity.getArtist());
            song.setAlbum(songEntity.getAlbum());
            song.setDescription(songEntity.getDescription());
            song.setName(songEntity.getName());
        }

        return song;
    }
}
