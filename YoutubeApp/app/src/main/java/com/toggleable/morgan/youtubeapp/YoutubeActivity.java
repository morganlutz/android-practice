package com.toggleable.morgan.youtubeapp;

import android.os.Bundle;
import android.widget.Toast;

public class YoutubeActivity implements YouTubePlayer.OnInitializedListener {

    private String GOOGLE_API_KEY = "AIzaSyAIAotGMKcwWybFik6mP68UESl99soweog";
    private String YOUTUBE_VIDEO_ID = "q6-ZGAGcJrk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);
        //generate override methods for onInitializationSuccess
        // change boolean b to boolean wasRestored
        //youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        //youTubePlayer.setPlaybackEventListener(playbackEventListener);
        //if(!wasRestored) {
        // youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        //}
        // && onInitializationFailure :
        //add Toast.makeText(this, "Cannot initialize Youtube player",
        //Toast.LENGTH_LONG).show();

        private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onPlaying() {
                Toast.makeText(YoutubeActivity.this, "Good, video is playing...", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onPaused() {
                Toast.makeText(YoutubeActivity.this, "Oh you paused??", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onStopped() {

            }

            @Override
            public void onBuffering(boolean b) {

            }

            @Override
            public void onSeekTo(int i) {

            }
        };

        private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {

            }

            @Override
            public void onLoaded(String s) {

            }

            @Override
            public void onAdStarted() {
                Toast.makeText(YoutubeActivity.this, "Make the video content author rich??", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onVideoStarted() {
                Toast.makeText(YoutubeActivity.this, "Video started!", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onVideoEnded() {

            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {

            }
        };

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
