package com.pencorp.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tuane on 3/02/17.
 */

public class UserEntity {

    @SerializedName("id")
    private int userId;

    public UserEntity() {
        //empty
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
