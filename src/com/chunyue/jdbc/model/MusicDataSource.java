package com.chunyue.jdbc.model;
// the java sql driver has to be present
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MusicDataSource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION = "jdbc:sqlite:/Users/chunyuema/desktop/developer/" + DB_NAME;

    // create the table and the columns
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";

    private Connection connection;

    // open the connection to the DB
    public boolean open(){
        try {
            connection = DriverManager.getConnection(CONNECTION);
            return true;
        } catch (SQLException e){
            System.out.println("Could not connect to DB: " + e.getMessage());
            return false;
        }
    }

    public void close(){
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e){
            System.out.println("Could not close the connection: " +  e.getMessage());
        }
    }

}
