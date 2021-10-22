package com.kbe.LC2.model;

public class Song {
    private final int id;
    private final String title;
    private final String artist;
    private final String label;
    private final int released;

    public Song(int id, String title, String artist, String label, int released) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.label = label;
        this.released = released;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getLabel() {
        return label;
    }

    public int getReleased() {
        return released;
    }
}
