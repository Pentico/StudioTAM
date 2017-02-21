package com.pencorp.studiotam.test.view.activity;

import com.pencorp.studiotam.R;
import com.pencorp.studiotam.View.activity.SongDetailsActivity;


import android.app.Fragment;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

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

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.setActivityIntent(createTargetIntent());
        this.songDetailsActivity = getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testContainsSongDetailsFragment() {
        Fragment songDetailsFragment =
                songDetailsActivity.getFragmentManager().findFragmentById(R.id.fragmentContainer);
        assertThat(songDetailsFragment, is(notNullValue()));
    }

    public void testContainsProperTitle() {
        String actualTitle = this.songDetailsActivity.getTitle().toString().trim();

        assertThat(actualTitle, is("Song Details"));
    }

    public void testLoadSongHappyCaseViews() {
        // TODO
    }

    public void testLoadSongHappyCaseData() {
        // TODO
    }

    private Intent createTargetIntent() {
        Intent intent =
                SongDetailsActivity.getCallingIntent(getInstrumentation().getTargetContext(), FAKE_SONG_ID);

        return intent;
    }
}
