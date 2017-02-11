package com.pencorp.studiotam.View.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pencorp.studiotam.R;
import com.pencorp.studiotam.View.SongDetailsView;
import com.pencorp.studiotam.internal.di.components.SongComponent;
import com.pencorp.studiotam.model.SongModel;
import com.pencorp.studiotam.presenter.SongDetailsPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Tuane on 11/02/17.
 */

/**
 * Fragment that shows details of a certian song.
 */
public class SongDetailsFragment extends BaseFragment implements SongDetailsView {

    @Inject
    SongDetailsPresenter songDetailsPresenter;

    public SongDetailsFragment() {
        setRetainInstance(true);
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

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return null;
    }
}
