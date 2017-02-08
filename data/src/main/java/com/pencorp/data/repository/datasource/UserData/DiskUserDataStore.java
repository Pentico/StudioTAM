package com.pencorp.data.repository.datasource.UserData;

import com.pencorp.data.cache.User.UserCache;
import com.pencorp.data.entity.UserEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by Tuane on 3/02/17.
 */

/**
 * {@link UserDataStore} implementation based on file system data store.
 */
public class DiskUserDataStore implements UserDataStore {

    private final UserCache userCache;

    /**
     * Construct a {@link UserDataStore} based file system data store.
     *
     * @param userCache A {@link UserCache} to cache data retrieved from the api.
     */
    DiskUserDataStore(UserCache userCache) {
        this.userCache = userCache;
    }

    @Override public Observable<List<UserEntity>> userEntityList() {
        //TODO: implement simple cache for storing/retrieving collections of users.
        throw new UnsupportedOperationException("Operation is not available!!!");
    }

    @Override public Observable<UserEntity> userEntityDetails(final int userId) {
        return this.userCache.get(userId);
    }
}
