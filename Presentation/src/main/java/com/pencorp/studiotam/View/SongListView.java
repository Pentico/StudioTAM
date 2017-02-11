package com.pencorp.studiotam.View;

import com.pencorp.studiotam.model.SongModel;

import java.util.Collection;

/**
 * Created by Tuane on 11/02/17.
 */

public interface SongListView extends LoadDataView {

    /**
     * Render a user list in the UI.
     *
     * @param songModelCollection The collection of {@link SongModel} that will be shown.
     */
    void renderSongList(Collection<SongModel> songModelCollection);

    /**
     * View a {@link SongModel} profile/details.
     *
     * @param songModel  The songthat will be shown.
     */
    void viewSong (SongModel songModel);
}
