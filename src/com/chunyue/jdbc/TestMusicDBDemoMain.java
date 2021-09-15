package com.chunyue.jdbc;

import com.chunyue.jdbc.model.Artist;
import com.chunyue.jdbc.model.MusicDataSource;

import java.util.List;

public class TestMusicDBDemoMain {
    public static void main(String[] args) {
        // create a new music data source instance
        MusicDataSource dataSource = new MusicDataSource();
        if (!dataSource.open()){
            System.out.println("Cannot open music data source");
            return;
        }
        List<Artist> artistList = dataSource.queryArtists();
        if (artistList == null){
            System.out.println("No artists");
            return;
        } else {
            for (Artist artist : artistList){
                System.out.println(artist);
            }
        }
        dataSource.close();
    }
}
