package com.chunyue.jdbc;

import com.chunyue.jdbc.model.Artist;
import com.chunyue.jdbc.model.MusicDataSource;
import com.chunyue.jdbc.model.SongArtist;

import java.util.ArrayList;
import java.util.List;

public class TestMusicDBDemoMain {
    public static void main(String[] args) {
        // create a new music data source instance
        MusicDataSource dataSource = new MusicDataSource();
        if (!dataSource.open()){
            System.out.println("Cannot open music data source");
            return;
        }

        // queryAllArtists(dataSource);
        queryAlbumWithArtist(dataSource, "Vladimir Vysotsky");
        // dataSource.querySongsMetaData();
        // useSingleSQLFunctionDemo(dataSource);
        // useMultipleSQLFunctionsDemo(dataSource);
        // createViewDemo(dataSource);
        // querySongInfoViewDemo(dataSource, "Go Your Own Way");
        // querySongInfoViewDemo(dataSource, "She's On Fire");

        dataSource.close();
    }

    public static void queryAllArtists(MusicDataSource dataSource){
        // query a list of artists
        List<Artist> artistList = dataSource.queryArtists(MusicDataSource.ORDER_BY_ASC);
        if (artistList.isEmpty()){
            System.out.println("No artists found from the database");
        } else {
            for (Artist artist : artistList){
                System.out.println(artist);
            }
        }
    }

    public static void queryAlbumWithArtist(MusicDataSource dataSource, String artistName){
        // query the albums based on an artist
        List<String> albumsForArtist = dataSource.queryAlbumForArtist(artistName, MusicDataSource.ORDER_BY_DESC);
        if (albumsForArtist != null){
            for (String album : albumsForArtist){
                System.out.println("Album Name: " + album);
            }
        } else {
            System.out.println("No albums found for this artist");
        }
    }

    public static void useSingleSQLFunctionDemo(MusicDataSource dataSource){
         int count = dataSource.getCount(MusicDataSource.TABLE_SONGS);
         System.out.println("Number of songs = " + count);
    }

    public static void useMultipleSQLFunctionsDemo(MusicDataSource dataSource){
        dataSource.getCountAndMin(MusicDataSource.TABLE_SONGS);
    }

    // create the view using jdbc
    public static void createViewDemo(MusicDataSource dataSource){
        dataSource.createViewForSongArtist();
    }

    // query the view using jdbc
    public static void querySongInfoViewDemo(MusicDataSource dataSource, String title){
        List<SongArtist> songArtistList = new ArrayList<>();
        songArtistList = dataSource.querySongInfoView(title);
        if (songArtistList.isEmpty()){
            System.out.println("Didn't find artist matching the song: " + title);
        } else {
            for (SongArtist songArtist : songArtistList){
                System.out.println(songArtist);
            }
        }
    }
}
