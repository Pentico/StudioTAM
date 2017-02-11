package com.pencorp.studiotam.internal.di.modules;

import com.pencorp.domain.executor.PostExecutionThread;
import com.pencorp.domain.executor.ThreadExecutor;
import com.pencorp.domain.interactor.GetSong;
import com.pencorp.domain.interactor.GetSongList;
import com.pencorp.domain.interactor.UseCase;
import com.pencorp.domain.repository.SongRepository;
import com.pencorp.studiotam.internal.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tuane on 9/02/17.
 */

@Module
public class SongModule {

    private long songId = -1;
    public SongModule() {}

    public SongModule(long songId) {
        this.songId = songId;
    }

    @Provides
    @PerActivity
    @Named("songList") UseCase provideGetSongListUseCase(
            GetSongList getSongList){
        return getSongList;
    }

    @Provides
    @PerActivity
    @Named("songDetails") UseCase provideGetSongDetailsUseCase(
            SongRepository songRepository, ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread) {
        return new GetSong(songId,songRepository, threadExecutor, postExecutionThread);
    }
}
