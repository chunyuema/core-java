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
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;


    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

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

    public List<Artist> queryArtists(int sortOrder){
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (sortOrder != ORDER_BY_NONE){
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC){
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }
        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sb.toString())) {
            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(INDEX_ARTIST_ID));
                artist.setName(resultSet.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }
            return artists;
        } catch(SQLException e) {
            System.out.println("Query Failed: " + e.getMessage());
            return null;
        }
    }
}
