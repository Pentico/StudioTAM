package com.pencorp.domain.repository;

import com.pencorp.domain.Song;

import java.util.List;

import rx.Observable;

/**
 * Created by Tuane on 3/02/17.
 */

public interface SongRepository {

    /**
     * Get an {@link rx.Observable} which will emit a List of {@link Song}.
     */
    Observable<List<Song>> songs();

    /**
     * Get an {@link rx.Observable} which will emit a {@link Song}.
     *
     * @param songId The user id used to retrieve user data.
     */
    Observable<Song> song(final int songId);
}
