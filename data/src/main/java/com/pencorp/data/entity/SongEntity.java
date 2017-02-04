package com.pencorp.data.entity;

import com.google.gson.annotations.SerializedName;


/**
 * Created by Tuane on 4/02/17.
 */

/**
 * Song Entity used in the data layer.
 */
public class SongEntity {

    @SerializedName("id")
    private long id;

    @SerializedName("filePath")
    private String filePath;

    @SerializedName("title")
    private String title       = "";

    @SerializedName("artist")
    private String artist      = "";

    @SerializedName("album")
    private String album       = "";

    @SerializedName("year")
    private int    year        = -1;

    @SerializedName("genre")
    private String genre       = "";

    @SerializedName("track_no")
    private int    track_no    = -1;

    @SerializedName("duration_ms")
    private long   duration_ms = -1;

    @SerializedName("coverUrl")
    private String coverUrl;

    public SongEntity() {
        //empty
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
