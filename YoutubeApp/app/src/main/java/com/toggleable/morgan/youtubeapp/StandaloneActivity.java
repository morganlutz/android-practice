package com.toggleable.morgan.youtubeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {

    private String GOOGLE_API_KEY = "AIzaSyAIAotGMKcwWybFik6mP68UESl99soweog";
    private String YOUTUBE_VIDEO_ID = "q6-ZGAGcJrk";
    private String YOUTUBE_PLAYLIST_ID = "XfI7gSO-Fgc&list=PL2fx9XU08mBIk4Ti9sCa8qcH8xDrB7eQW";

    private Button btnPlayVideo;
    private Button btnPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);
        btnPlaylist = (Button) findViewById(R.id.btnPlaylist);
        btnPlayVideo.setOnClickListener(this);
        btnPlaylist.setOnClickListener(this);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch(v.getId()) {
            case R.id.btnPlayVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlaylist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, YOUTUBE_PLAYLIST_ID);
                break;
            default:
        }
        if(intent != null) {
            startActivity(intent);
        }
    }

}
