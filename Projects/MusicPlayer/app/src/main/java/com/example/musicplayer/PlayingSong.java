package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PlayingSong extends AppCompatActivity {
    private TextView songView;
    private ImageView playpause, nextView, prevView;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private int position;
    private String songName;
    private ArrayList<File> songs;
    Thread updateSeek;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_song);

        songView = findViewById(R.id.songnameinplaysong);
        playpause = findViewById(R.id.playpause);
        nextView = findViewById(R.id.next);
        prevView = findViewById(R.id.prev);
        seekBar = findViewById(R.id.seekBar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        songs = (ArrayList) bundle.getParcelableArrayList("songlist");
        songName = intent.getStringExtra("currentsong");
        position = intent.getIntExtra("position", -1);
        songView.setSelected(true);

        Uri uri = Uri.parse(songs.get(position).toString());
        mediaPlayer = MediaPlayer.create(this, uri);
        mediaPlayer.start();
        songView.setText(songName);
        playpause.setImageResource(R.drawable.pause);
        seekBar.setMax(mediaPlayer.getDuration());

        setSeekToBegin();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });

        updateSeek = new Thread(){
            @Override
            public void run() {
                super.run();
                int currentPosition = 0;
                try{
                    while(currentPosition < mediaPlayer.getDuration())
                    {
                        currentPosition = mediaPlayer.getCurrentPosition();
                        seekBar.setProgress(currentPosition);
                        sleep(800);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        updateSeek.start();
    }

    public void setPlaypause(View view)
    {
       if(mediaPlayer.isPlaying())
       {
           mediaPlayer.pause();
           playpause.setImageResource(R.drawable.play);
       }
       else
       {
           mediaPlayer.start();
           playpause.setImageResource(R.drawable.pause);
       }
    }

    public void setPrevView(View view)
    {
        setSeekToBegin();
        mediaPlayer.stop();
        mediaPlayer.release();

        if(position != 0)
            position--;
        else
            position = songs.size() - 1;

        String currentSongName = songs.get(position).getName();
        Uri uri = Uri.parse(songs.get(position).toString());
        mediaPlayer = MediaPlayer.create(this, uri);
        mediaPlayer.start();
        playpause.setImageResource(R.drawable.pause);
        songView.setText(currentSongName);
        seekBar.setMax(mediaPlayer.getDuration());
    }

    public void setNextView(View view)
    {
        setSeekToBegin();
        mediaPlayer.stop();
        mediaPlayer.release();

        if(position < songs.size() - 1)
            position++;
        else
            position = 0;

        String currentSongName = songs.get(position).getName();
        Uri uri = Uri.parse(songs.get(position).toString());
        mediaPlayer = MediaPlayer.create(this, uri);
        mediaPlayer.start();
        playpause.setImageResource(R.drawable.pause);
        songView.setText(currentSongName);
        seekBar.setMax(mediaPlayer.getDuration());
    }

    public void setSeekToBegin()
    {
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

                if(position < songs.size() - 1)
                {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    position++;
                    Uri uri = Uri.parse(songs.get(position).getName());
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), uri);
                    mediaPlayer.start();
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        updateSeek.interrupt();
    }
}