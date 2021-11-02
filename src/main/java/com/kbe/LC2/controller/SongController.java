package com.kbe.LC2.controller;

//import com.kbe.LC2.database.SongsRepository;
import com.kbe.LC2.model.IdGenerator;
import com.kbe.LC2.model.Song;
import com.kbe.LC2.model.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class SongController {

    private SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("LC2/songs")
    @ResponseBody
    public List<Song> allSongs(){
        return songRepository.findAll();
    }

    @GetMapping(value="/LC2/songs/{id}")
    @ResponseBody //legt rückgabewert als json in die HTTP response auf diese GET Anfrage
    public Optional<Song> getSongByID(@PathVariable("id") long id) {
        return songRepository.findById(id);
        //return songLoader.getSong(id);
    }

    @PostMapping(value="/LC2/songs", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> addNewSong(@Validated @RequestBody Song newSong){
        newSong.setId(IdGenerator.getFreeSongId());
        Song savedSong = songRepository.save(newSong);
        IdGenerator.updateFreeSongID(savedSong.getId());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedSong.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value="/LC2/songs/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteSong(@PathVariable("id") long id){
        songRepository.deleteById(id);
    }
}
