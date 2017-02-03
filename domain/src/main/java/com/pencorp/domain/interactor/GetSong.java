package com.pencorp.domain.interactor;

import com.pencorp.domain.executor.PostExecutionThread;
import com.pencorp.domain.executor.ThreadExecutor;
import com.pencorp.domain.repository.SongRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Tuane on 3/02/17.
 */

public class GetSong extends UseCase {

    private final int songId;
    private final SongRepository songRepository;

    @Inject
    public GetSong(int songId, SongRepository songRepository,
            ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.songId = songId;
        this.songRepository = songRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.songRepository.song(this.songId);
    }
}
