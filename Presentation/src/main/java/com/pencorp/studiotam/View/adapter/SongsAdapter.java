package com.pencorp.studiotam.View.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tuane on 10/02/17.
 */

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongViewHolder> {

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class SongViewHolder extends RecyclerView.ViewHolder {

        public SongViewHolder(View itemView) {
            super(itemView);
        }
    }
}

