package com.example.wertonguimaraes.musicalstructure.model;


public class Music {
    private String mTitle;
    private String mArtist;

    public Music(String title, String artist) {
        mTitle = title;
        mArtist = artist;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getArtist() {
        return mArtist;
    }
}