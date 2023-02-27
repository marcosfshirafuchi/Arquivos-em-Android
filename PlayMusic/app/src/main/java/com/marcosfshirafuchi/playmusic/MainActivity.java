package com.marcosfshirafuchi.playmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView pause, play,stop;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperar os ids dos componentes
        pause = findViewById(R.id.pause);
        play = findViewById(R.id.play);
        stop = findViewById(R.id.stop);

        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.global);

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer != null){
                    mediaPlayer.start();
                }

            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.global);
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    //Ciclo de vida onStop
    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer !=null && mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}