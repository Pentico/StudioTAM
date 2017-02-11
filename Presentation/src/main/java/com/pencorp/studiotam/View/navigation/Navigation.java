package com.pencorp.studiotam.View.navigation;

import android.content.Context;
import android.content.Intent;

import com.pencorp.studiotam.View.activity.SongDetailsActivity;
import com.pencorp.studiotam.View.activity.SongListActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Tuane on 5/02/17.
 */


/**
 * Class used to navigate through the application.
 */
@Singleton
public class Navigation {

    @Inject
    public Navigation() {
        //empty
    }

    /**
     * Goes to the song list screen.
     *
     * @param context A Context needed to open the destiny activity.
     */
    public void navigatetToSongList(Context context) {
        if (context != null) {
            Intent intentToLaunch = SongListActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }

    /**
     * Goes to the song details screen.
     *
     * @param context A Context needed to open the destiny activity.
     * @param songId
     */
    public void navigateToSongDetails(Context context, long songId) {
        if (context != null) {
            Intent intentToLaunch = SongDetailsActivity.getCallingIntent(context, songId);
            context.startActivity(intentToLaunch);
        }
    }

}
