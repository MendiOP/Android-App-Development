package com.example.recyclerview;

public class ModelClass {
    private int imageView;
    private String name, text, time, divider;

    public ModelClass(int imageView, String name, String text, String time, String divider) {
        this.imageView = imageView;
        this.name = name;
        this.text = text;
        this.time = time;
        this.divider = divider;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDivider() {
        return divider;
    }

    public void setDivider(String divider) {
        this.divider = divider;
    }
}
