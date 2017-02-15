package com.pencorp.data.repository.datasource.SongData;

/**
 * Created by Tuane on 4/02/17.
 */

import com.pencorp.data.cache.Song.SongCache;
import com.pencorp.data.entity.SongEntity;
import com.pencorp.data.media.RestSongsApi;
import com.pencorp.data.media.RestSongsApiImpl;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * {@link SongDataStore} implementation based on file system data store.
 */
public class DiskSongDataStore implements SongDataStore {

    private final SongCache songCache;
    private  final RestSongsApi restSongsApi;

    /**
     * Construct a {@link SongDataStore} based file system data store.
     *
     * @param songCache A {@link SongCache} to cache data retrieved from the api.
     * @param restSongsApi
     */
    public DiskSongDataStore(SongCache songCache, RestSongsApi restSongsApi) {
        this.songCache = songCache;
        this.restSongsApi = restSongsApi;
    }


    @Override
    public Observable<List<SongEntity>> songEntityList() {
       return this.songCache.get();
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

    private final Action1<List<SongEntity>> savetoCacheAction = songEntityList -> {
        if( songEntityList != null) {
            DiskSongDataStore.this.songCache.put(songEntityList);
        }
    };


}
