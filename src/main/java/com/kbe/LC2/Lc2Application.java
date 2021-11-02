package com.kbe.LC2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lc2Application {

	public static void main(String[] args) {
		SpringApplication.run(Lc2Application.class, args);

		/*
		String songFile = "src/main/resources/songs.json";
		Song[] JSONSongs = Song.loadJSONSongs(songFile);

		for (Song s: JSONSongs
			 ) {
			System.out.println(s);
		}
		 */
	}

}
