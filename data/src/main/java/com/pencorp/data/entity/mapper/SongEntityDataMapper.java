package com.pencorp.data.entity.mapper;

import com.pencorp.data.entity.SongEntity;
import com.pencorp.domain.Song;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    /**
     * Transform a List of {@link SongEntity} into a Collection of {@link Song  }
     * @param songEntityCollection
     * @return {@link Song} if valid {@link SongEntity} otherwise null.
     *
     */
    public List<Song> transform(Collection<SongEntity> songEntityCollection) {
        List<Song> songList = new ArrayList<>();
        Song song;
        for (SongEntity songEntity : songEntityCollection) {
            song = transform(songEntity);
            if(song != null){
                songList.add(song);
            }
        }

        return songList;
    }
}
