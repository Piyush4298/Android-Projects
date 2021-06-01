package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton play,pause,stop;
    MediaPlayer mediaPlayer;
    int pausePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (ImageButton)findViewById(R.id.play);
        pause = (ImageButton)findViewById(R.id.pause);
        stop = (ImageButton)findViewById(R.id.stop);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.play:
                if(mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dilbar);
                    mediaPlayer.start();
                }else if (!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pausePosition);
                    mediaPlayer.start();
                }
                break;
            case R.id.pause:
                if (mediaPlayer!=null){
                    mediaPlayer.pause();
                    pausePosition = mediaPlayer.getCurrentPosition();
                }
                break;
            case R.id.stop:
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
                break;
        }
    }
}