package com.pencorp.data.repository;

/**
 * Created by Tuane on 3/02/17.
 */

import com.pencorp.data.entity.mapper.UserEntityDataMapper;
import com.pencorp.data.repository.datasource.UserData.UserDataStore;
import com.pencorp.data.repository.datasource.UserData.UserDataStoreFactory;
import com.pencorp.domain.User;
import com.pencorp.domain.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * {@link UserRepository} for retrieving user data.
 */
@Singleton
public class UserDataRepository implements UserRepository {

    private final UserDataStoreFactory userDataStoreFactory;
    private final UserEntityDataMapper userEntityDataMapper;

    @Inject
    public UserDataRepository(UserDataStoreFactory dataStoreFactory,
                              UserEntityDataMapper userEntityDataMapper){
        this.userDataStoreFactory = dataStoreFactory;
        this.userEntityDataMapper = userEntityDataMapper;
    }

    @Override public Observable<User> user(int userId) {
        final UserDataStore userDataStore = this.userDataStoreFactory.create(userId);
        return userDataStore.userEntityDetails(userId).map(this.userEntityDataMapper::transform);
    }
}

