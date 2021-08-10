package com.chunyue.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB {
    public static void main(String[] args) {
        createDBwithTryCatch();
        createDBWithTryResourceCatch();
    }

    public static void createDBwithTryCatch(){
        try {
            // specify the path you want to create the db file
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/chunyuema/desktop/developer" +
                    "/testjava.db");
            // statement is associated with the connection
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
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
            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
        } catch (SQLException e){
            System.out.println("Failed to connect to db: " + e.getMessage());
        }
    }
}
