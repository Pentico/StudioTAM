package com.pencorp.studiotam.View.activity;

import com.pencorp.studiotam.View.fragment.SongListFragment;
import com.pencorp.studiotam.internal.di.HasComponent;
import com.pencorp.studiotam.internal.di.components.SongComponent;

/**
 * Created by Tuane on 11/02/17.
 */

public class SongListActivity extends BaseActivity implements HasComponent<SongComponent>,
        SongListFragment.SongListListener{

    @Override
    public SongComponent getComponent() {
        return null;
    }
}
