package com.example.JavaDataDisplay.models;

public class HomeData {
    private String name;
    private String genre;
    private String track;

    public HomeData(String name, String genre, String track) {
        this.name = name;
        this.genre = genre;
        this.track = track;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }
}
