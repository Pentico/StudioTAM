package com.pencorp.domain.interactor;

import com.pencorp.domain.executor.PostExecutionThread;
import com.pencorp.domain.executor.ThreadExecutor;
import com.pencorp.domain.repository.SongRepository;

import rx.Observable;

/**
 * Created by Tuane on 9/02/17.
 */

public class GetSongList extends UseCase {

    private final SongRepository songRepository;

    protected GetSongList(ThreadExecutor threadExecutor,
                          PostExecutionThread postExecutionThread, SongRepository songRepository) {
        super(threadExecutor, postExecutionThread);
        this.songRepository = songRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.songRepository.songs();
    }
}
