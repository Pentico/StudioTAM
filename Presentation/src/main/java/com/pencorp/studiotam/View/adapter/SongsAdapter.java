package com.pencorp.studiotam.View.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pencorp.studiotam.R;
import com.pencorp.studiotam.model.SongModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tuane on 10/02/17.
 */

/**
 * Adapter that manages a collection of {@link SongModel}
 */
public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongViewHolder> {



    private List<SongModel> songsCollection;
    private final LayoutInflater layoutInflater;

    private OnItemClickListener onItemClickListener;

    @Inject
    public SongsAdapter(Context context) {
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.songsCollection = Collections.emptyList();
    }

    public interface onItemClickListener {
        void onSongItemClicked(SongModel songModel);
    }
    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.row_song, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        final SongModel songModel = this.songsCollection.get(position);
        holder.textViewTitle.setText(songModel.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SongsAdapter.this.onItemClickListener != null){
                    SongsAdapter.this.onItemClickListener.onSongItemCliked(songModel);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (this.songsCollection != null) ? this.songsCollection.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        return  position;
    }

    public void setSongsCollection(Collection<SongModel> songsCollection) {

        this.validateSongsCollection(songsCollection);
        this.songsCollection = (List<SongModel>) songsCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateSongsCollection(Collection<SongModel> songsCollection){
        if (songsCollection == null){
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    static class SongViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.title)
        TextView textViewTitle;
        public SongViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

