package com.pencorp.studiotam.internal.di.components;

import android.app.Activity;

import com.pencorp.studiotam.internal.di.PerActivity;
import com.pencorp.studiotam.internal.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by Tuane on 3/02/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
