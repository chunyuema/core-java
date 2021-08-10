package com.chunyue.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
    public static void main(String[] args) {
        // createDBwithTryCatch();
        // createDBWithTryResourceCatch();
        // insertToDB();
        // updateDB();
        // deleteEntryFromDB();
    }

    public static void createDBwithTryCatch(){
        try {
            // specify the path you want to create the db file
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/chunyuema/desktop/developer" +
                    "/testjava.db");
            // statement is associated with the connection
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
            // close the statement before the connection
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Failed to connect to db: " + e.getMessage());
        }
    }

    public static void createDBWithTryResourceCatch(){
        // will automatically close the connection after execution
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/chunyuema/desktop/developer" +
                "/testjava2.db");
            Statement statement = connection.createStatement()){
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
        } catch (SQLException e){
            System.out.println("Failed to connect to db: " + e.getMessage());
        }
    }

    public static void insertToDB(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/chunyuema/desktop/developer" +
                    "/testjava.db");
            // turning of autocommit will cause the data not being persistent after closing the connection
            // connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Joe', '789532','joe01')");
            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Lily', '148672','lily01')");
            statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Logan', '798214','logan01')");
            statement.close();
            connection.close();
        }catch (SQLException e){
            System.out.println("Failed! " + e.getMessage());
        }
    }

    public static void updateDB(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/chunyuema/desktop/developer" +
                    "/testjava.db");
            Statement statement = connection.createStatement();
            statement.execute("UPDATE contacts SET phone=11111 WHERE name='Joe'");
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Fail to update: " + e.getMessage());
        }
    }

    public static void deleteEntryFromDB(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/chunyuema/desktop/developer" +
                    "/testjava.db");
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM contacts WHERE name='Joe'");
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Fail to update: " + e.getMessage());
        }
    }
}
