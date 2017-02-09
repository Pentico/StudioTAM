package com.pencorp.studiotam.mapper;

import com.pencorp.domain.Song;
import com.pencorp.studiotam.internal.di.PerActivity;
import com.pencorp.studiotam.model.SongModel;

import javax.inject.Inject;

/**
 * Created by Tuane on 9/02/17.
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
    }
}
