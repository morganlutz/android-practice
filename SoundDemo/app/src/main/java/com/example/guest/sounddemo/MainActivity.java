package com.example.guest.sounddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.media.MediaPlayer;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button playSound = (Button) findViewById(R.id.btnPlay);

        playSound.OnClickListener() {

        }
//        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.zombie);
//
//        mPlayer.start();
    }

}
