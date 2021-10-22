package com.kbe.LC2.database;

import com.kbe.LC2.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongsRepository extends JpaRepository<Song, Long> {
}
