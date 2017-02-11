package com.pencorp.studiotam.View.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.pencorp.studiotam.R;
import com.pencorp.studiotam.View.fragment.SongListFragment;
import com.pencorp.studiotam.internal.di.HasComponent;
import com.pencorp.studiotam.internal.di.components.SongComponent;
import com.pencorp.studiotam.internal.di.components.UserComponent;
import com.pencorp.studiotam.model.SongModel;

/**
 * Created by Tuane on 11/02/17.
 */

public class SongListActivity extends BaseActivity implements HasComponent<SongComponent>,
        SongListFragment.SongListListener{


    public static Intent getCallingIntent(Context context) {
        return new Intent(context, SongListActivity.class);
    }

    private SongComponent songComponent;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_layout);

        this.initializeInjector();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new SongListFragment());
        }
    }

    @Override
    public SongComponent getComponent() {
        return songComponent;
    }

    private void initializeInjector() {
        this.songComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public void onSongClicked(SongModel songModel) {
        this.navigation.navigateToSongDetails(this, songModel.getSongId());
    }

}
