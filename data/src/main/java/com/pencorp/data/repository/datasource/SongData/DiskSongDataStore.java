package com.pencorp.data.repository.datasource.SongData;

/**
 * Created by Tuane on 4/02/17.
 */

import com.pencorp.data.cache.Song.SongCache;
import com.pencorp.data.entity.SongEntity;
import com.pencorp.data.media.RestSongsApiImpl;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * {@link SongDataStore} implementation based on file system data store.
 */
public class DiskSongDataStore implements SongDataStore {

    private final SongCache songCache;
    private  RestSongsApiImpl restSongsApi;

    /**
     * Construct a {@link SongDataStore} based file system data store.
     *
     * @param songCache A {@link SongCache} to cache data retrieved from the api.
     * @param restSongsApi
     */
    public DiskSongDataStore(SongCache songCache, RestSongsApiImpl restSongsApi) {
        this.songCache = songCache;
        this.restSongsApi = restSongsApi;
    }

    public DiskSongDataStore(SongCache songCache) {
        this.songCache = songCache;
    }

    @Override
    public Observable<List<SongEntity>> songEntityList() {
       return this.restSongsApi.userEntityList();
    }

    @Override
    public Observable<SongEntity> songEntityDetails(final long songId) {
        return this.songCache.get(songId);
    }

    private final Action1<SongEntity> saveToCacheAction = songEntity -> {
        if( songEntity != null){
            DiskSongDataStore.this.songCache.put(songEntity);
        }
    };


}
