package com.pencorp.domain.repository;

import com.pencorp.domain.User;

import java.util.List;

import rx.Observable;

/**
 * Created by Tuane on 3/02/17.
 */

public interface UserRepository {

    /**
     * Get an {@link rx.Observable} which will emit a {@link User}.
     *
     * @param userId The user id used to retrieve user data.
     */
    Observable<User> user(final int userId);
}
