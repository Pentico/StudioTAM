package com.pencorp.domain.repository;

import com.pencorp.domain.Song;

import java.util.List;

import rx.Observable;

/**
 * Created by Tuane on 3/02/17.
 */

public interface SongRepository {

    /**
     * Get an {@link rx.Observable} which will emit a {@link Song}.
     *
     * @param songId The song id used to retrieve song data.
     */
    Observable<Song> song(final long songId);
}
