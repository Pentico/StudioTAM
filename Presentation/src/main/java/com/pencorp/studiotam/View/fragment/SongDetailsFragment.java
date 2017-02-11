package com.pencorp.studiotam.View.fragment;

import android.content.Context;

import com.pencorp.studiotam.View.SongDetailsView;
import com.pencorp.studiotam.model.SongModel;

/**
 * Created by Tuane on 11/02/17.
 */

/**
 * Fragment that shows details of a certian song.
 */
public class SongDetailsFragment extends BaseFragment implements SongDetailsView {
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
