package com.pencorp.studiotam.test.view.activity;

import com.pencorp.studiotam.R;
import com.pencorp.studiotam.View.activity.SongDetailsActivity;


import android.app.Fragment;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
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
        onView(withId(R.id.rl_retry)).check(matches(not(isDisplayed())));
        onView(withId(R.id.rl_progress)).check(matches(not(isDisplayed())));

        onView(withId(R.id.tv_album)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_artist)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_album)).check(matches(isDisplayed()));
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
