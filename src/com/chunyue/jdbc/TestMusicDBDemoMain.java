package com.chunyue.jdbc;

public class TestMusicDBDemoMain {
    public static void main(String[] args) {
        MusicDataSource dataSource = new MusicDataSource();
        if (!dataSource.open()){
            System.out.println("Cannot open music data source");
            return;
        }
        dataSource.close();
    }
}
