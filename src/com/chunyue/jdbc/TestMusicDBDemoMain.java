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
        dataSource.close();
    }
}
