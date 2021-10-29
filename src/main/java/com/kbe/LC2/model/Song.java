package com.kbe.LC2.model;

import javax.persistence.*;
import javax.validation.constraints.*;

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
    private long id;
    @NotBlank(message = "title may not be blank")
    @Size(min=1,max=200,message = "title must be between 1 and 200 characters long")
    private String title;
    @NotBlank(message = "artist may not be blank")
    @Size(min=1,max=200,message = "artist must be between 1 and 200 characters long")
    private String artist;
    @NotBlank(message = "label may not be blank")
    @Size(min=1,max=200,message = "label must be between 1 and 200 characters long")
    private String label;
    @NotNull(message= "released may not be null")
    @Min(value=1000, message = "released must be greater than 999")
    @Max(value=2021,message="released must be smaller than 2022 or")
    private int released;

    //used for db initialization
    public Song(long id, String title, String artist, String label, int released) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.label = label;
        this.released = released;
    }

    public Song(String title, String artist, String label, int released) {
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

    public void setId(long newId){
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setReleased(int released) {
        this.released = released;
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
