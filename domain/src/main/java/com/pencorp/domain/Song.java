package com.pencorp.domain;

/**
 * Created by Tuane on 3/02/17.
 */

public class Song {

    private final int songId;

    public Song(int songId){
        this.songId = songId;
    }

    private String coverUrl;
    private String description;
    private String name;
    private String artist;
    private String album;
    private int year;

    public int getSongId() {
        return songId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
