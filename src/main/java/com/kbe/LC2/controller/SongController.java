package com.kbe.LC2.controller;

//import com.kbe.LC2.database.SongsRepository;
import com.kbe.LC2.model.Song;
import com.kbe.LC2.model.SongLoader;
import com.kbe.LC2.model.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SongController {

    private SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    private String songFile = "src/main/resources/songs.json";
    private SongLoader songLoader = new SongLoader(songFile);

    @GetMapping("LC2/songs")
    public List<Song> allSongs(){
        return songRepository.findAll();
    }

    @GetMapping(value="/LC2/songs/{id}")
    @ResponseBody
    public Optional<Song> getSongByID(@PathVariable("id") long id) {
        return songRepository.findById(id);
        //return songLoader.getSong(id);
    }

    @PostMapping(value="/LC2/songs", consumes = "application/json", produces = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewSong(@RequestBody Song newSong){
        songRepository.save(newSong);
        //Song addedSong = songLoader.addSong(newSong);
        ///////
        //TODO ADD LOCATION TO HEADER IN RESPONSE
        /////
    }
}
