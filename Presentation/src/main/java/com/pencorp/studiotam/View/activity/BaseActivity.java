package com.pencorp.studiotam.View.activity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.pencorp.studiotam.AndroidApplication;
import com.pencorp.studiotam.View.navigation.Navigation;
import com.pencorp.studiotam.internal.di.components.ApplicationComponent;
import com.pencorp.studiotam.internal.di.modules.ActivityModule;

import javax.inject.Inject;

/**
 * Created by Tuane on 3/02/17.
 */

/**
 * Base {@link android.app.Activity} class for every Activity in
 * this application.
 */
public abstract class BaseActivity extends Activity {
    @Inject
    Navigation navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationContext().inject(this);
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        android.app.FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Get the Main Application component for dependency injection.
     * @return {@link ApplicationComponent}
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     * @return {@link ActivityModule}
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
