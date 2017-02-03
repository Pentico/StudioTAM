package com.pencorp.studiotam;

/**
 * Created by Tuane on 3/02/17.
 */

import android.app.Application;

import com.pencorp.studiotam.internal.di.components.ApplicationComponent;
import com.pencorp.studiotam.internal.di.components.DaggerApplicationComponent;
import com.pencorp.studiotam.internal.di.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Android Main Application
 */
public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }
}