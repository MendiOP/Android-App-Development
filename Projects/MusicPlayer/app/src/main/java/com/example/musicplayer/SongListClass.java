package com.example.musicplayer;

public class SongListClass {
    private int imageView;
    private String songName;

    public SongListClass(int imageView, String songName) {
        this.imageView = imageView;
        this.songName = songName;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}
