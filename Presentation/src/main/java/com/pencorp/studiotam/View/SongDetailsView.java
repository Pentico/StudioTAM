package com.pencorp.studiotam.View;

/**
 * Created by Tuane on 10/02/17.
 */

import com.pencorp.studiotam.model.SongModel;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a user profile.
 */
public interface  SongDetailsView extends LoadDataView  {

    /**
     * Render a song in the UI.
     *
     * @param song The {@link  SongModel} that will be shown.
     */
    void renderSong(SongModel song);

}
