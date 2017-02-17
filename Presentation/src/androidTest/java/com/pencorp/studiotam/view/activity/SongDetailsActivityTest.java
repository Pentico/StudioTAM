package com.pencorp.studiotam.view.activity;

import com.pencorp.studiotam.View.activity.SongDetailsActivity;


import android.test.ActivityInstrumentationTestCase2;



/**
 * Created by Tuane on 17/02/17.
 */

public class SongDetailsActivityTest  extends
        ActivityInstrumentationTestCase2<SongDetailsActivity> {

    private static final long FAKE_SONG_ID = 264;
    private static final String FAKE_SONG_PATH = "sdCard/music/";

    private SongDetailsActivity songDetailsActivity;

    public SongDetailsActivityTest() {
        super(SongDetailsActivity.class);
    }
}
