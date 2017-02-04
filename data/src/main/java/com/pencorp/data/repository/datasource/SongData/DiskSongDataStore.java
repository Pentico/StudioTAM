package com.pencorp.data.repository.datasource.SongData;

/**
 * Created by Tuane on 4/02/17.
 */

import com.pencorp.data.cache.SongCache;
import com.pencorp.data.entity.SongEntity;

import java.util.List;

import rx.Observable;

/**
 * {@link SongDataStore} implementation based on file system data store.
 */
public class DiskSongDataStore implements SongDataStore {

    private final SongCache songCache;

    /**
     * Construct a {@link SongDataStore} based file system data store.
     *
     * @param songCache A {@link SongCache} to cache data retrieved from the api.
     */
    public DiskSongDataStore(SongCache songCache) {
        this.songCache = songCache;
    }

    @Override
    public Observable<List<SongEntity>> songEntityList() {
        //TODO: implement simple cache for storing/retrieving collections of song.
        throw new UnsupportedOperationException("Operation is not available!!!");

    }

    @Override
    public Observable<SongEntity> songEntityDetails(final long songId) {
        return this.songCache.get(songId);
    }


}
