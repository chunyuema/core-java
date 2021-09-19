package com.chunyue.jdbc;

import com.chunyue.jdbc.model.MusicDataSource;

public class TestMusicDBDemoMain {
    public static void main(String[] args) {
        // create a new music data source instance
        MusicDataSource dataSource = new MusicDataSource();
        if (!dataSource.open()){
            System.out.println("Cannot open music data source");
            return;
        }

        // query a list of artists
//        List<Artist> artistList = dataSource.queryArtists(MusicDataSource.ORDER_BY_ASC);
//        if (artistList == null){
//            System.out.println("No artists");
//            return;
//        } else {
//            for (Artist artist : artistList){
//                System.out.println(artist);
//            }
//        }

        // query the albums based on an artist
//        List<String> albumsForArtist = dataSource.queryAlbumForArtist("Pink Floyd", MusicDataSource.ORDER_BY_DESC);
//        if (albumsForArtist != null){
//            for (String album : albumsForArtist){
//                System.out.println(album);
//            }
//        } else {
//            System.out.println("No albums found for this artist");
//        }
//
//        List<SongArtist> songArtistList = dataSource.queryArtistForSong("Go Your Own Way",
//                MusicDataSource.ORDER_BY_ASC);
//        if (songArtistList == null){
//            System.out.println("Could not find the artist for the song");
//            return;
//        }
//        for (SongArtist artist : songArtistList){
//            System.out.println(artist);
//        }


        dataSource.querySongsMetaData();
        dataSource.close();
    }
}
