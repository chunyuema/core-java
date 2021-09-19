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
        List<Artist> artistList = dataSource.queryArtists(MusicDataSource.ORDER_BY_ASC);
        if (artistList == null){
            System.out.println("No artists");
            return;
        } else {
            for (Artist artist : artistList){
                System.out.println(artist);
            }
        }

        List<String> albumsForArtist = dataSource.queryAlbumForArtist("Iron Maiden", MusicDataSource.ORDER_BY_ASC);
        if (albumsForArtist != null){
            System.out.println(albumsForArtist);
            for (String album : albumsForArtist){
                System.out.println(album);
            }
        } else {
            System.out.println("No albums");
        }
        dataSource.close();
    }
}
