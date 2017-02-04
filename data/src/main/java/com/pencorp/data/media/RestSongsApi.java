package com.pencorp.data.media;

import com.pencorp.data.entity.SongEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by Tuane on 4/02/17.
 */


/**
 * RestApi for retrieving data from the memory.
 */
public interface RestSongsApi {

    /**
     * Retrieves an {@link rx.Observable} which will emit a List of {@link SongEntity}.
     */
    Observable<List<SongEntity>> userEntityList();
}
