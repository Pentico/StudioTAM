package com.pencorp.data.repository;

import com.pencorp.data.entity.mapper.SongEntityDataMapper;
import com.pencorp.data.repository.datasource.SongData.SongDataStore;
import com.pencorp.data.repository.datasource.SongData.SongDataStoreFactory;
import com.pencorp.domain.Song;
import com.pencorp.domain.repository.SongRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by Tuane on 3/02/17.
 */


/**
 * {@link SongRepository} for retrieving user data.
 */
@Singleton
public class SongDataRepository  implements SongRepository{

    private final SongEntityDataMapper songEntityDataMapper;
    private final SongDataStoreFactory songDataStoreFactory;

    @Inject
    public SongDataRepository(SongEntityDataMapper songEntityDataMapper,
                              SongDataStoreFactory songDataStoreFactory) {
        this.songEntityDataMapper = songEntityDataMapper;
        this.songDataStoreFactory = songDataStoreFactory;
    }

    @Override
    public Observable<Song> song(long songId) {
        final SongDataStore songDataStore = this.songDataStoreFactory.create(songId);
        return songDataStore.songEntityDetails(songId).map(this.songEntityDataMapper::transform);
    }

}
