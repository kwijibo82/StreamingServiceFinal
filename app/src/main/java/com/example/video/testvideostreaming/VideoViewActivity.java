package com.example.video.testvideostreaming;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Javi on 18/04/2015.
 */
public class VideoViewActivity extends Activity
{
    // Declare variables
    ProgressDialog pDialog;
    VideoView videoview;

    // Insert your Video URL
    String VideoURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoview_main);
        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null) {
            VideoURL = bundle.getString("url");

            videoview = (VideoView) findViewById(R.id.VideoView);
            pDialog = new ProgressDialog(VideoViewActivity.this);
            pDialog.setTitle("Streaming de video");
            pDialog.setMessage("Buffering...");
            pDialog.setIndeterminate(true);
            pDialog.setCancelable(true);
            pDialog.show();

            try {

                MediaController mediacontroller = new MediaController(
                        VideoViewActivity.this);
                mediacontroller.setAnchorView(videoview);

                Uri video = Uri.parse(VideoURL);
                videoview.setMediaController(mediacontroller);
                videoview.setVideoURI(video);

            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }

            videoview.requestFocus();
            videoview.setOnPreparedListener(new OnPreparedListener() {
                // Close the progress bar and play the video
                public void onPrepared(MediaPlayer mp) {
                    pDialog.dismiss();
                    videoview.start();
                }
            });

        }

    }
}
