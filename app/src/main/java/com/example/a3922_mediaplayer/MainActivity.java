package com.example.a3922_mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton play, pause, slow, fast, rewind, stop;
    MediaPlayer mediaPlayer;
    boolean isPlaying = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.playButton);
        pause = findViewById(R.id.pauseButton);
        stop = findViewById(R.id.stopButton);
        slow = findViewById(R.id.slowButton);
        fast = findViewById(R.id.fastButton);
        rewind = findViewById(R.id.rewindButton);

        mediaPlayer = MediaPlayer.create(this,R.raw.song1);
//        for playing the music
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isPlaying){
                    mediaPlayer.start();
                    isPlaying = true;
                    Toast.makeText(getApplicationContext(), "Playing song", Toast.LENGTH_SHORT).show();
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying){
                    mediaPlayer.pause();
                    isPlaying = false;
                    Toast.makeText(getApplicationContext(), "Pause", Toast.LENGTH_SHORT).show();
                }

            }
        });
        slow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()-5000);
                Toast.makeText(getApplicationContext(), "Slow", Toast.LENGTH_SHORT).show();
            }
        });
        fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition()+5000);
                Toast.makeText(getApplicationContext(), "Fast Forward", Toast.LENGTH_SHORT).show();
            }
        });
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mediaPlayer.reset();
//                mediaPlayer.start();
                mediaPlayer.seekTo(0);
                Toast.makeText(getApplicationContext(), "Rewind", Toast.LENGTH_SHORT).show();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying){
                    mediaPlayer.stop();
                    isPlaying = false;
                    Toast.makeText(getApplicationContext(), "Stop", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}