package com.pencorp.studiotam.test.view.activity;

import android.app.Fragment;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

import com.pencorp.studiotam.R;
import com.pencorp.studiotam.View.activity.SongListActivity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Fragment songListFragment =
                songListActivity.getFragmentManager().findFragmentById(R.id.fragmentContainer);
        assertThat(songListFragment, is(notNullValue()));
    }

    public void testContainsProperTitle() {

        String actualTitle = this.songListActivity.getTitle().toString().trim();

        assertThat(actualTitle, is("Songs List"));
    }


    private Intent createTargetIntent() {
        Intent intent =
                SongListActivity.getCallingIntent(getInstrumentation().getTargetContext());
        return intent;
    }
}
