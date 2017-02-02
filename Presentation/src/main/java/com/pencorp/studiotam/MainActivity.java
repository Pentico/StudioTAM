package com.pencorp.studiotam;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;


public class MainActivity extends Activity {
    
    @Inject
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
