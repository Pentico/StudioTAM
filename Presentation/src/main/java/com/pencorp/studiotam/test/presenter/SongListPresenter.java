package com.pencorp.studiotam.test.presenter;

import android.support.annotation.NonNull;

import com.pencorp.domain.Song;
import com.pencorp.domain.exception.DefaultErrorBundle;
import com.pencorp.domain.exception.ErrorBundle;
import com.pencorp.domain.interactor.DefaultSubscriber;
import com.pencorp.domain.interactor.UseCase;
import com.pencorp.studiotam.View.SongListView;
import com.pencorp.studiotam.test.exception.ErrorMessageFactory;
import com.pencorp.studiotam.internal.di.PerActivity;
import com.pencorp.studiotam.test.mapper.SongModelDataMapper;
import com.pencorp.studiotam.model.SongModel;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Tuane on 11/02/17.
 */

@PerActivity
public class SongListPresenter implements Presenter {

    private SongListView songListView;

    private final UseCase getSongListUseCase;
    private final SongModelDataMapper songModelDataMapper;

    @Inject
    public SongListPresenter(@Named("songList") UseCase getSongListUseCase,
                             SongModelDataMapper songModelDataMapper) {
        this.getSongListUseCase = getSongListUseCase;
        this.songModelDataMapper = songModelDataMapper;
    }

    public void setView(@NonNull SongListView view) {
        this.songListView = view;
    }


    @Override public void resume() {}

    @Override public void pause() {}

    @Override public void destroy() {
        this.getSongListUseCase.unsubscribe();
        this.songListView = null;
    }

    /**
     * Initializes the presenter by start retrieving the user list.
     */
    public void initialize() {
        this.loadSongList();
    }

    /**
     * Loads all songs.
     */
    private void loadSongList() {
        this.hideViewRetry();
        this.showViewLoading();
        this.getSongList();
    }

    public void onUserClicked(SongModel songModel) {
        this.songListView.viewSong(songModel);
    }

    private void showViewLoading() {
        this.songListView.showLoading();
    }

    private void hideViewLoading() {
        this.songListView.hideLoading();
    }

    private void showViewRetry() {
        this.songListView.showRetry();
    }

    private void hideViewRetry() {
        this.songListView.hideRetry();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.songListView.context(),
                errorBundle.getException());
        this.songListView.showError(errorMessage);
    }

    private void showSongCollectionInView(Collection<Song> songCollection) {
        final Collection<SongModel> songModelsCollection =
                this.songModelDataMapper.transform(songCollection);
        this.songListView.renderSongList(songModelsCollection);
    }

    private void getSongList() {
        this.getSongListUseCase.execute(new SongListSubscriber());
    }

    private final class SongListSubscriber extends DefaultSubscriber<List<Song>> {

        @Override
        public void onCompleted() {
            SongListPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            SongListPresenter.this.hideViewLoading();
            SongListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            SongListPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(List<Song> songs) {
            SongListPresenter.this.showSongCollectionInView(songs);
        }
    }
}
