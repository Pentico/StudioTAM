package com.pencorp.data.repository.datasource.UserData;

import android.content.Context;
import android.support.annotation.NonNull;

import com.pencorp.data.cache.User.UserCache;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Tuane on 3/02/17.
 */

/**
 * Factory that creates different implementations of {@link UserDataStore}.
 */
@Singleton
public class UserDataStoreFactory {

    private final Context context;
    private final UserCache userCache;

    @Inject
    public UserDataStoreFactory(@NonNull Context context, @NonNull UserCache userCache) {
        this.context = context.getApplicationContext();
        this.userCache = userCache;
    }

    /**
     * Create {@link UserDataStore} from a user id.
     */
    public UserDataStore create(int userId) {
        UserDataStore userDataStore;
        userDataStore = new DiskUserDataStore(this.userCache);

        // TODO impliment CloudDataStore().
       /* if (!this.userCache.isExpired() && this.userCache.isCached(userId)) {
            userDataStore = new DiskUserDataStore(this.userCache);
        } else {
            userDataStore = createCloudDataStore();
        }*/

        return userDataStore;
    }

   /* *//**
     * Create {@link UserDataStore} to retrieve data from the Cloud.
     *//*
    public UserDataStore createCloudDataStore() {
        UserEntityJsonMapper userEntityJsonMapper = new UserEntityJsonMapper();
        RestApi restApi = new RestApiImpl(this.context, userEntityJsonMapper);

        return new CloudUserDataStore(restApi, this.userCache);
    }*/
}
