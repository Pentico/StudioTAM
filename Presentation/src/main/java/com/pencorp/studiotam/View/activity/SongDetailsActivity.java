package com.pencorp.studiotam.View.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.pencorp.studiotam.R;
import com.pencorp.studiotam.internal.di.HasComponent;
import com.pencorp.studiotam.internal.di.components.SongComponent;
import com.pencorp.studiotam.internal.di.modules.SongModule;

/**
 * Created by Tuane on 10/02/17.
 */

/**
 * Activity that shows details of a certain song
 */
public class SongDetailsActivity extends BaseActivity implements HasComponent<SongComponent> {

    private static final String INTENT_EXTRA_PARAM_SONG_ID = "org.studiotam.INTENT_PARAM_SONG_ID";
    private static final String INSTANCE_STATE_PARAM_SONG_ID = "org.studiota.INTENT_PARAM_SONG_ID";
    private int songId;
    private SongComponent songComponent;


    public  static Intent getCallingIntent(Context context, int songId) {
        Intent callingIntent = new Intent(context, SongDetailsActivity.class);
        callingIntent.putExtra(INTENT_EXTRA_PARAM_SONG_ID, songId);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);

        this.initializeActivity(savedInstanceState);
        this.initializeInjector();
    }

    /**
     * Initializes this activity.
     */
    private void initializeActivity(Bundle savedInstanceState) {
        if(savedInstanceState == null) {
            this.songId = getIntent().getIntExtra(INTENT_EXTRA_PARAM_SONG_ID, -1);
            addFragment(R.id.fragmentContainer, new SongDetailsActivity());
        }else {
            this.songId = savedInstanceState.getInt(INSTANCE_STATE_PARAM_SONG_ID);
        }
    }

    private void initializeInjector() {
        this.songComponent = DaggerSongComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .userModule(new SongModule(this.songId))
                .build();
    }

    @Override
    public SongComponent getComponent() {
        return songComponent;
    }
}
