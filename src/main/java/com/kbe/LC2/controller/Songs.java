package com.kbe.LC2.controller;

import com.kbe.LC2.database.SongsRepository;
import com.kbe.LC2.model.Song;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Songs {

    public final SongsRepository repository;

    public Songs(SongsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/LC/songs/id")
    public String index() {
        return "bar";
    }
}
