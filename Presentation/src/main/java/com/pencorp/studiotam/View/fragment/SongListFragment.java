package com.pencorp.studiotam.View.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.pencorp.studiotam.R;
import com.pencorp.studiotam.View.SongListView;
import com.pencorp.studiotam.View.adapter.SongsAdapter;
import com.pencorp.studiotam.View.adapter.SongsLayoutManager;
import com.pencorp.studiotam.internal.di.components.SongComponent;
import com.pencorp.studiotam.model.SongModel;
import com.pencorp.studiotam.test.presenter.SongListPresenter;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tuane on 11/02/17.
 */

/**
 * Fragment that shows a list of Songs.
 */
public class SongListFragment extends BaseFragment implements SongListView {

    private SongListListener songListListener;

    @Inject
    SongListPresenter songListPresenter;
    @Inject
    SongsAdapter songsAdapter;

    @Bind(R.id.rv_songs)
    RecyclerView rv_songs;
    @Bind(R.id.rl_progress)
    RelativeLayout rl_progress;
    @Bind(R.id.rl_retry)
    RelativeLayout rl_retry;
    @Bind(R.id.bt_retry)
    Button bt_retry;

    public SongListFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof SongListListener) {
            this.songListListener = (SongListListener) activity;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(SongComponent.class).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup conainer,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_song_list, conainer, false);
        ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.songListPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadSongList();
        }
    }

    /**
     * Interface for listening user list events.
     */
    public interface SongListListener {
        void onSongClicked(final SongModel userModel);
    }

    @Override
    public void renderSongList(Collection<SongModel> songModelCollection) {
        if (songModelCollection != null) {
            this.songsAdapter.setSongsCollection(songModelCollection);
        }
    }

    @Override
    public void viewSong(SongModel songModel) {
        if (this.songListListener != null) {
            this.songListListener.onSongClicked(songModel);
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
        return this.getActivity().getApplicationContext();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.songListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.songListPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rv_songs.setAdapter(null);
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.songListPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.songListListener = null;
    }

    private void setupRecyclerView() {
        this.songsAdapter.setOnItemClickListener(onItemClickListener);
        this.rv_songs.setLayoutManager(new SongsLayoutManager(context()));
        this.rv_songs.setAdapter(songsAdapter);
    }

    /**
     * Loads all songs.
     */
    private void loadSongList() {
        this.songListPresenter.initialize();
    }

    @OnClick(R.id.bt_retry)
    void onButtonRetryClick() {
        SongListFragment.this.loadSongList();
    }

    private SongsAdapter.OnItemClickListener onItemClickListener =
            new SongsAdapter.OnItemClickListener() {
                @Override public void onSongItemClicked(SongModel songModel) {
                    if (SongListFragment.this.songListPresenter != null && songModel != null) {
                        SongListFragment.this.songListPresenter.onUserClicked(songModel);
                    }
                }
            };
}
