package com.pencorp.studiotam.model;

import com.pencorp.studiotam.internal.di.PerActivity;

import javax.inject.Inject;

/**
 * Created by Tuane on 9/02/17.
 * Class that represents a song in the presentation layer.
 */
public class SongModel {

    private  final long songId;

    public SongModel(long songId){
        this.songId = songId;
    }

}
