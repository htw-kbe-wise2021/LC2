package com.kbe.LC2.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;

//import javax.persistence.Entity;
//import javax.persistence.Id;
import java.io.File;
import java.io.IOException;


//@Entity
public class Song {
    //private @Id
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
