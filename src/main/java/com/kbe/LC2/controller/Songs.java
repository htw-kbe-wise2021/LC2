package com.kbe.LC2.controller;

//import com.kbe.LC2.database.SongsRepository;
import com.kbe.LC2.model.Song;
import com.kbe.LC2.model.SongLoader;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Songs {

    /*public final SongsRepository repository;

    public Songs(SongsRepository repository) {
        this.repository = repository;
    }
     */

    private String songFile = "src/main/resources/songs.json";
    private SongLoader songLoader = new SongLoader(songFile);

    @GetMapping("LC2/songs")
    public List<Song> all(){
        return List.of(songLoader.getLoadedJSONSongs());
    }

    @GetMapping(value="/LC2/songs/{id}")
    @ResponseBody
    public Song getSongByID(@PathVariable("id") long id) {
        return songLoader.getSong(id);
    }
}
