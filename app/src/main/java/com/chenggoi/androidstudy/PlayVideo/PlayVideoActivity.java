package com.chenggoi.androidstudy.PlayVideo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.chenggoi.androidstudy.R;

import java.io.File;

/**
 * Created by chenggoi on 16-8-8.
 */

public class PlayVideoActivity extends Activity implements View.OnClickListener {
    private Button play;
    private Button pause;
    private Button replay;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_video_activity);

        play = (Button) findViewById(R.id.play_video);
        pause = (Button) findViewById(R.id.pause_vedio);
        replay = (Button) findViewById(R.id.replay_video);
        videoView = (VideoView) findViewById(R.id.video_view);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
        initVideoPath();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (videoView != null) {
            videoView.suspend();
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.play_video:
                if (!videoView.isPlaying()) {
                    videoView.start();
                }
                break;
            case R.id.pause_vedio:
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
                break;
            case R.id.replay_video:
                if (videoView.isPlaying()) {
                    videoView.resume();
                }
                break;
            default:
                break;
        }
    }

    private void initVideoPath() {

        File file = new File(Environment.getExternalStorageDirectory(), "movie.3gp");
        videoView.setVideoPath(file.getPath());
    }
}
