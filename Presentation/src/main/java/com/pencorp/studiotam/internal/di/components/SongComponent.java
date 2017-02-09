package com.pencorp.studiotam.internal.di.components;

import com.pencorp.studiotam.internal.di.PerActivity;
import com.pencorp.studiotam.internal.di.modules.ActivityModule;
import com.pencorp.studiotam.internal.di.modules.SongModule;

import dagger.Component;

/**
 * Created by Tuane on 9/02/17.
 * 
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,
            modules = {ActivityModule.class,
                    SongModule.class})
public interface SongComponent extends ActivityComponent {
}
