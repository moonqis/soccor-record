package com.example.dazuoye;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class win extends AppCompatActivity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();

        }

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int url = intent.getIntExtra("url", R.raw.win);
        setContentView(R.layout.win);
        //本地的视频  需要在手机SD卡根目录添加一个 fl1234.mp4 视频
        // String videoUrl1 = Environment.getExternalStorageDirectory().getPath()+"/video1.mp4" ;
        videoView = (VideoView) this.findViewById(R.id.videoView);
        //设置视频控制器
        videoView.setMediaController(new MediaController(this));
        //播放完成回调
        videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());
        //设置视频路径
        videoView.setVideoURI(Uri.parse("android.resource://com.example.dazuoye/" + url));
        //开始播放视频
        videoView.start();
        Log.i("text", "11");
    }
    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener{
        @Override
        public void onCompletion(MediaPlayer mp){
            Toast.makeText(win.this,"播放完成了",Toast.LENGTH_SHORT).show();
        }
    }
}
