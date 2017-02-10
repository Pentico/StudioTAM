package com.pencorp.studiotam.model;

import com.pencorp.studiotam.internal.di.PerActivity;

import javax.inject.Inject;

/**
 * Created by Tuane on 9/02/17.
 * Class that represents a song in the presentation layer.
 */
public class SongModel {

    private  final long songId;
    private String title       = "";
    private String artist      = "";
    private String album       = "";
    private int    year        = -1;
    private String genre       = "";
    private int    track_no    = -1;
    private long   duration_ms = -1;


    public SongModel(long songId){
        this.songId = songId;
    }

    public long getSongId() {
        return songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTrack_no() {
        return track_no;
    }

    public void setTrack_no(int track_no) {
        this.track_no = track_no;
    }

    public long getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(long duration_ms) {
        this.duration_ms = duration_ms;
    }
}
