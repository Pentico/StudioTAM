package com.pencorp.data.repository.datasource.UserData;

import com.pencorp.data.entity.UserEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by Tuane on 3/02/17.
 */

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface UserDataStore {

    /**
     * Get an {@link rx.Observable} which will emit a List of {@link UserEntity}.
     */
    Observable<List<UserEntity>> userEntityList();

    /**
     * Get an {@link rx.Observable} which will emit a {@link UserEntity} by its id.
     *
     * @param userId The id to retrieve user data.
     */
    Observable<UserEntity> userEntityDetails(final int userId);
}
