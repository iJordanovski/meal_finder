package com.creativehub.foodfinder.feature.youtubevideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.creativehub.foodfinder.R;

public class YoutubeVideoActivity extends AppCompatActivity {
    private final static String VIDEO_URL = "videoUrl";

    public static void start(Context context, String videoUrl) {
        Intent intent = new Intent(context, YoutubeVideoActivity.class);
        intent.putExtra(VIDEO_URL, videoUrl);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_video);
        setupUi();
    }

    private void setupUi() {
        String videoUrl = getIntent().getStringExtra(VIDEO_URL);
        Log.d("YoutubeVideoActivity",videoUrl);
    }

}