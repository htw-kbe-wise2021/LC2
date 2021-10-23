package com.kbe.LC2.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SongLoader {

    private Song[] loadedJSONSongs;

    public SongLoader(){
        String songFile = "src/main/resources/songs.json";
        this.loadedJSONSongs = this.loadJSONSongs(songFile);
    }

    public SongLoader(String songFile){
        this.loadedJSONSongs = this.loadJSONSongs(songFile);
    }

    public Song[] getLoadedJSONSongs() {
        return loadedJSONSongs;
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

    private Song[] loadJSONSongs(String fileLocation){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Song[] loadedJSONSongs = objectMapper.readValue(new File(fileLocation), Song[].class);
            return loadedJSONSongs;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
