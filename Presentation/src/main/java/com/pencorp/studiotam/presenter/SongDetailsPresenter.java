package com.pencorp.studiotam.presenter;

import android.support.annotation.NonNull;

import com.pencorp.domain.interactor.UseCase;
import com.pencorp.studiotam.View.SongDetailsView;
import com.pencorp.studiotam.internal.di.PerActivity;
import com.pencorp.studiotam.mapper.SongModelDataMapper;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Tuane on 10/02/17.
 */

/**
 * {@link Presenter} that controls communication between views and
 * models of the presentation
 * layer.
 */
@PerActivity
public class SongDetailsPresenter implements Presenter {

    private SongDetailsView songDetailsView;

    private final UseCase getSongDetailsUseCase;
    private final SongModelDataMapper songModelDataMapper;

    @Inject
    public SongDetailsPresenter(@Named("songDetails") UseCase getSongDetailsUseCase,
                                SongModelDataMapper songModelDataMapper) {
        this.getSongDetailsUseCase = getSongDetailsUseCase;
        this.songModelDataMapper = songModelDataMapper;
    }

    public void setView(@NonNull SongDetailsView view) {
        this.songDetailsView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.getSongDetailsUseCase.unsubscribe();
        this.songDetailsView = null;
    }

    /**
     * Initialize the presenter by start retrieving song details.
     */
    public void initialize() {
        this.loadSongDetails();
    }

    /**
     * Loads song details
     */
    private void loadSongDetails() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getSongDetails();
    }

    
}
