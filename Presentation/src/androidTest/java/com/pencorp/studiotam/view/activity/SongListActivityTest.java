package com.pencorp.studiotam.view.activity;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase;
import android.test.ActivityInstrumentationTestCase2;

import com.pencorp.studiotam.View.activity.SongListActivity;

/**
 * Created by Tuane on 17/02/17.
 */

public class SongListActivityTest extends
        ActivityInstrumentationTestCase2<SongListActivity> {

    private SongListActivity songListActivity;

    public SongListActivityTest() {
        super(SongListActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.setActivityIntent(createTargetIntent());
        songListActivity = getActivity();
    } // EOF

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    } // EOF

    public void testContainsSongListFragment() {

    }

    public void testContainsProperTitle() {

    }


    private Intent createTargetIntent() {
        Intent intent =
                SongListActivity.getCallingIntent(getInstrumentation().getTargetContext());
        return intent;
    }
}
