package com.pencorp.data.cache;

import com.pencorp.data.entity.SongEntity;

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
     * Puts and element into the cache.
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
