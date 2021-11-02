package com.kbe.LC2.model;

public class IdGenerator {

    private static long freeSongId;

    public static long getFreeSongId() {
        return freeSongId;
    }

    private static void setFreeSongId(long freeSongId) {
        IdGenerator.freeSongId = freeSongId;
    }

    public static void updateFreeSongID(long lastSongId){
        if(lastSongId >= IdGenerator.getFreeSongId()) IdGenerator.setFreeSongId(lastSongId + 1);
    }

    public static void initFreeSongID(long initialFreeSongID){
        IdGenerator.setFreeSongId(initialFreeSongID);
    }
}
