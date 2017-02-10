package com.pencorp.studiotam.View.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.pencorp.studiotam.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @Bind(R.id.btn_LoadData)
    Button btn_LoadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * Goes to the song list screen
     */
    void navigateToSongList(){

    }
}
