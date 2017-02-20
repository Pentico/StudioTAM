package com.pencorp.studiotam.test.presenter;

import android.support.annotation.NonNull;

import com.fernandocejas.frodo.annotation.RxLogSubscriber;
import com.pencorp.domain.Song;
import com.pencorp.domain.exception.DefaultErrorBundle;
import com.pencorp.domain.exception.ErrorBundle;
import com.pencorp.domain.interactor.DefaultSubscriber;
import com.pencorp.domain.interactor.UseCase;
import com.pencorp.studiotam.View.SongDetailsView;
import com.pencorp.studiotam.test.exception.ErrorMessageFactory;
import com.pencorp.studiotam.internal.di.PerActivity;
import com.pencorp.studiotam.test.mapper.SongModelDataMapper;
import com.pencorp.studiotam.model.SongModel;

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

    private void showViewLoading() {
        this.songDetailsView.showLoading();
    }

    private void hideViewLoading() {
        this.songDetailsView.hideLoading();
    }

    private void hideViewRetry() {
        this.songDetailsView.hideRetry();
    }

    private void showViewRetry() {
        this.songDetailsView.showRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(
                this.songDetailsView.context(), errorBundle.getException()
        );
        this.songDetailsView.showError(errorMessage);
    }

    private void showSongDetailsInView(Song song) {
        final SongModel songModel = this.songModelDataMapper.transform(song);
        this.songDetailsView.renderSong(songModel);
    }

    private void getSongDetails() {
        this.getSongDetailsUseCase.execute(new SongDetailsSubscriber());
    }

    @RxLogSubscriber
    private final class SongDetailsSubscriber extends DefaultSubscriber<Song> {

        @Override
        public void onCompleted() {
            SongDetailsPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            SongDetailsPresenter.this.hideViewLoading();
            SongDetailsPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception ) e));
            SongDetailsPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(Song song) {
            SongDetailsPresenter.this.showSongDetailsInView(song);
        }
    }
}
