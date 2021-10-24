package com.kbe.LC2.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SongLoader {

    private List<Song> loadedJSONSongs;

    private long nextSongID;

    public SongLoader(){
        String songFile = "src/main/resources/songs.json";
        this.loadedJSONSongs = this.loadJSONSongs(songFile);

        initializeNextSongID();
    }

    public SongLoader(String songFile){
        this.loadedJSONSongs = this.loadJSONSongs(songFile);

        initializeNextSongID();
    }

    public List<Song> getLoadedJSONSongs() {
        return loadedJSONSongs;
    }

    public void addSong(Song newSong){
        newSong.setId(this.nextSongID);
        this.loadedJSONSongs.add(newSong);

        updateNextSongID();
    }

    public Song getSong(long songID){
        for (Song loadedSong: loadedJSONSongs
             ) {
            if(loadedSong.id == songID){
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
            if(s.getId() > newID) newID++;
        }
        this.nextSongID = newID;
    }

    private void updateNextSongID(){
        this.nextSongID++;
    }
}
