package com.pencorp.domain;

/**
 * Created by Tuane on 3/02/17.
 */

public class User {

    private final int userId;

    public User(int userId) {
        this.userId = userId;
    }

    private String coverUrl;
    private String fullName;
    private String email;

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }
}
