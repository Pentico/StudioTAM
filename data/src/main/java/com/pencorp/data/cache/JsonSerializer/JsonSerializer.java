package com.pencorp.data.cache.JsonSerializer;

/**
 * Created by Tuane on 3/02/17.
 */

import com.google.gson.Gson;
import com.pencorp.data.entity.SongEntity;
import com.pencorp.data.entity.UserEntity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class user as Serializer/Deserializer for user entities.
 */
@Singleton
public class JsonSerializer {

    private final Gson gson = new Gson();

    @Inject
    public JsonSerializer() {}

    /**
     * Serialize an object to Json.
     *
     * @param userEntity {@link UserEntity} to serialize.
     */
    public String serializeUser(UserEntity userEntity) {
        String jsonString = gson.toJson(userEntity, UserEntity.class);
        return jsonString;
    }

    /**
     * Deserialize a json representation of an object.
     *
     * @param jsonString A json string to deserialize.
     * @return {@link UserEntity}
     */
    public UserEntity deserializeUser(String jsonString) {
        UserEntity userEntity = gson.fromJson(jsonString, UserEntity.class);
        return userEntity;
    }

    /**
     * Serialize an object to Json.
     *
     * @param songEntity {@link SongEntity} to serialize.
     */
    public String serializeSong(SongEntity songEntity) {
        String jsonString = gson.toJson(songEntity, SongEntity.class);
        return jsonString;
    }

    /**
     * Deserialize a json representation of an object.
     *
     * @param jsonString A json string to deserialize.
     * @return {@link SongEntity}
     */
    public SongEntity deserializeSong(String jsonString) {
        SongEntity songEntity = gson.fromJson(jsonString, SongEntity.class);
        return songEntity;
    }
}
