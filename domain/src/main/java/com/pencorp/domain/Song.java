package com.pencorp.domain;

/**
 * Created by Tuane on 3/02/17.
 */

public class Song {

    private final long songId;
    private final String filepath;

    public Song(long songId, String filepath){
        this.songId = songId;
        this.filepath = filepath;
    }

    private String coverUrl;
    private String title;
    private String artist;
    private String album;
    private int year;
    private String genre;
    private int track_no;
    private long duration_ms;

    public long getSongId() {
        return songId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getFilepath() {
        return filepath;
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

    public long getDurationSeconds() {
        return getDuration_ms() / 1000;
    }

    public long getDurationMinutes() {
        return getDurationSeconds() / 60;
    }
}
