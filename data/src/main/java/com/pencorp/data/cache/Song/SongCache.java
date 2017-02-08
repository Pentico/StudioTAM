package com.pencorp.data.cache.Song;

import com.pencorp.data.entity.SongEntity;
import com.pencorp.domain.Song;

import java.util.List;

import rx.Observable;

/**
 * Created by Tuane on 3/02/17.
 */

public interface SongCache {

    /**
     * Gets an {@link rx.Observable} which will emit a {@link SongEntity}.
     *
     * @param songId The user id to retrieve data.
     */
    Observable<SongEntity> get(final long songId);

    /**
     * Get an {@link rx.Observable} which will emit a list of {@link SongEntity}
     *
     * @return  List of SongEntity
     */
    Observable<List<SongEntity>> get();

    /**
     * Puts  an ArrayList Element in the cache
     *
     * @param songEntityList Element to insert in the cache.
     */
    void put( List<SongEntity> songEntityList);


    /**
     * Puts an element into the cache.
     *
     * @param songEntity Element to insert in the cache.
     */
    void put(SongEntity songEntity);

    /**
     * Checks if an element (Song) exists in the cache.
     *
     * @param songId The id used to look for inside the cache.
     * @return true if the element is cached, otherwise false.
     */
    boolean isCached(final long songId);

    /**
     * Checks if the cache is expired.
     *
     * @return true, the cache is expired, otherwise false.
     */
    boolean isExpired();

    /**
     * Evict all elements of the cache.
     */
    void evictAll();
}
