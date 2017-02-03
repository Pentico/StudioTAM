package com.pencorp.studiotam.internal.di.modules;

import android.app.Activity;

import com.pencorp.studiotam.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Tuane on 3/02/17.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
