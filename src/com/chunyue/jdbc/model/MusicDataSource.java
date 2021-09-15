package com.chunyue.jdbc.model;
// the java sql driver has to be present

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Artist> queryArtists(){
        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS);) {
            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(COLUMN_ARTISTS_ID));
                artist.setName(resultSet.getString(COLUMN_ARTISTS_NAME));
                artists.add(artist);
            }
            return artists;
        } catch(SQLException e) {
            System.out.println("Query Failed: " + e.getMessage());
            return null;
        }
    }
}
