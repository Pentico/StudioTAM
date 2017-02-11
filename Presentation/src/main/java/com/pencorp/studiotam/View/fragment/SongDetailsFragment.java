package com.pencorp.studiotam.View.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pencorp.studiotam.R;
import com.pencorp.studiotam.View.SongDetailsView;
import com.pencorp.studiotam.internal.di.components.SongComponent;
import com.pencorp.studiotam.model.SongModel;
import com.pencorp.studiotam.presenter.SongDetailsPresenter;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tuane on 11/02/17.
 */

/**
 * Fragment that shows details of a certian song.
 */
public class SongDetailsFragment extends BaseFragment implements SongDetailsView {

    @Inject
    SongDetailsPresenter songDetailsPresenter;

    @Bind(R.id.tv_title)
    TextView tv_title;
    @Bind(R.id.tv_artist)
    TextView tv_artist;
    @Bind(R.id.tv_album)
    TextView tv_album;
    @Bind(R.id.rl_progress)
    RelativeLayout rl_progress;
    @Bind(R.id.rl_retry)
    RelativeLayout rl_retry;
    @Bind(R.id.bt_retry)
    Button bt_retry;

    public SongDetailsFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        this.songDetailsPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.songDetailsPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.songDetailsPresenter.destroy();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(SongComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_song_details, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.songDetailsPresenter.setView(this);
        if(savedInstanceState == null){
            this.loadSongDetails();
        }
    }

    @Override
    public void renderSong(SongModel song) {

        if(song != null) {
            this.tv_album.setText(song.getAlbum());
            this.tv_artist.setText(song.getArtist());
            this.tv_title.setText(song.getTitle());
        }
    }

    @Override
    public void showLoading() {
        this.rl_progress.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
        this.rl_progress.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showRetry() {
        this.rl_retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.rl_retry.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        this.showToastMessage(message);
    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }

    /**
     * Loads all Songs
     */
    private void loadSongDetails() {
        if(this.songDetailsPresenter != null) {
            this.songDetailsPresenter.initailize();
        }
    }

    @OnClick(R.id.bt_retry)
    void onButtonRetryClick() {
        SongDetailsFragment.this.loadSongDetails();
    }
}
