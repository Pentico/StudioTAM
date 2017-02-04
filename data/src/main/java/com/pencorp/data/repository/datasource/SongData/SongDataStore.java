package com.pencorp.data.repository.datasource.SongData;

/**
 * Created by Tuane on 3/02/17.
 */

import com.pencorp.data.entity.SongEntity;

import java.util.List;

import rx.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface SongDataStore {

    /**
     * Get an {@link rx.Observable} which will emit a List of {@link SongEntity}.
     */
    Observable<List<SongEntity>> songEntityList();

    /**
     * Get an {@link rx.Observable} which will emit a {@link SongEntity} by its Id.
     *
     * @param songId The id to retrieve song data.
     */
    Observable<SongEntity> songEntityDetails(final long songId);
}

