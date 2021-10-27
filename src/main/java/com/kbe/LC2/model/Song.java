package com.kbe.LC2.model;

import javax.persistence.*;

@Entity
@Table(name = "Song")
public class Song {

    /////
    //PROBLEM: initialValue has to be known before runtime
    //this is ok if the database is always wiped after run or if the
    //server nerver goes down otherwise, this requieres a different solution

    //NVM this doesnt respect the given ids
    //I will solve keeping the given ids later
    //for now there will be new ids for the songs from the json
    ////
    @Id
    @SequenceGenerator(
            name="songSequence",
            initialValue = 10,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "songSequence"
    )
    private long id;
    private String title;
    private String artist;
    private String label;
    private int released;

    public Song(long id, String title, String artist, String label, int released) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.label = label;
        this.released = released;
    }

    public Song() {

    }

    public long getId() {
        return id;
    }

    protected void setId(long newId){
        this.id = newId;
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

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", label='" + label + '\'' +
                ", released=" + released +
                '}';
    }
}
