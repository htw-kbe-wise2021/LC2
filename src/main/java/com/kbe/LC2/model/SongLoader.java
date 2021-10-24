package com.kbe.LC2.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SongLoader {

    private List<Song> loadedJSONSongs;

    private long nextSongID;

    public SongLoader(){
        String songFile = "src/main/resources/songs.json";
        this.loadedJSONSongs = new LinkedList<>();
        this.loadedJSONSongs.addAll(this.loadJSONSongs(songFile));

        initializeNextSongID();
    }

    public SongLoader(String songFile){
        this.loadedJSONSongs = new LinkedList<>();
        this.loadedJSONSongs.addAll(this.loadJSONSongs(songFile));

        initializeNextSongID();
    }

    public List<Song> getLoadedJSONSongs() {
        return loadedJSONSongs;
    }

    public Song addSong(Song newSong){
        long newSongID = this.nextSongID;
        newSong.setId(newSongID);
        this.loadedJSONSongs.add(newSong);

        updateNextSongID();

        return this.getSong(newSongID);
    }

    public Song getSong(long songID){
        for (Song loadedSong: this.loadedJSONSongs
             ) {
            if(loadedSong.getId() == songID){
                return loadedSong;
            }
        }
        return null;
    }

    private List<Song> loadJSONSongs(String fileLocation){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Song[] loadedJSONSongs = objectMapper.readValue(new File(fileLocation), Song[].class);
            return Arrays.asList(loadedJSONSongs);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void initializeNextSongID(){
        long newID = 0;
        for (Song s: this.loadedJSONSongs
        ) {
            if(s.getId() > newID) newID = s.getId() + 1;
        }
        this.nextSongID = newID;
    }

    private void updateNextSongID(){
        this.nextSongID++;
    }
}
