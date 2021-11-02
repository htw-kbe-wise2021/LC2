package com.kbe.LC2.database;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kbe.LC2.model.IdGenerator;
import com.kbe.LC2.model.Song;
import com.kbe.LC2.model.SongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(SongRepository repository) {

        IdGenerator.initFreeSongID(1);

        String songFile = "src/main/resources/songs.json";
        List<Song> songsFromJSONFile = new LinkedList<>();
        songsFromJSONFile.addAll(this.loadJSONSongs(songFile));

        System.out.println("Songs loaded from " + songFile + " into List");

        return args -> {
            for (Song song: songsFromJSONFile
                 ) {
                log.info("Preloading " + repository.save(song));
                IdGenerator.updateFreeSongID(song.getId());
            }
        };

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
}