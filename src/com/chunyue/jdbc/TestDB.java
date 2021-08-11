package com.chunyue.jdbc;

import java.sql.*;

public class TestDB {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION = "jdbc:sqlite:/Users/chunyuema/desktop/developer/" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COULMN_NAME = "name";
    public static final String COULMN_PHONE = "phone";
    public static final String COULMN_EMAIL = "email";

    public static void main(String[] args) {
        // createDBwithTryCatch();
        // createDBWithTryResourceCatch();
        // insertToDB();
        // updateDB();
        // deleteEntryFromDB();
        // queryDBWithExecute();
        // queryDBWithExecuteStatment();
        // avoidHardCodedSQLStatement();
    }

    public static void createDBwithTryCatch() {
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
        } catch (SQLException e) {
            System.out.println("Failed to connect to db: " + e.getMessage());
        }
    }

    public static void createDBWithTryResourceCatch() {
        // will automatically close the connection after execution
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/chunyuema/desktop/developer" +
                "/testjava2.db");
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
        } catch (SQLException e) {
            System.out.println("Failed to connect to db: " + e.getMessage());
        }
    }

    public static void insertToDB() {
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
        } catch (SQLException e) {
            System.out.println("Failed! " + e.getMessage());
        }
    }

    public static void updateDB() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/chunyuema/desktop/developer" +
                    "/testjava.db");
            Statement statement = connection.createStatement();
            statement.execute("UPDATE contacts SET phone=11111 WHERE name='Joe'");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Fail to update: " + e.getMessage());
        }
    }

    public static void deleteEntryFromDB() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/chunyuema/desktop/developer" +
                    "/testjava.db");
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM contacts WHERE name='Joe'");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Fail to update: " + e.getMessage());
        }
    }

    public static void queryDBWithExecute() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/chunyuema/desktop/developer" +
                    "/testjava.db");
            Statement statement = connection.createStatement();
            statement.execute("SELECT * FROM contacts");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " +
                        resultSet.getInt("phone") + " " +
                        resultSet.getString("email"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Fail to query: " + e.getMessage());
        }
    }

    public static void queryDBWithExecuteStatment() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/chunyuema/desktop/developer" +
                    "/testjava.db");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " +
                        resultSet.getInt("phone") + " " +
                        resultSet.getString("email"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to query" + e);
        }
    }

    public static void avoidHardCodedSQLStatement() {
        try {
            Connection connection = DriverManager.getConnection(CONNECTION);
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    " (" + COULMN_NAME + " text, " +
                    COULMN_PHONE + " integer, " +
                    COULMN_EMAIL + " text" +
                    ")");

            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    " (" + COULMN_NAME + ", " +
                    COULMN_PHONE + ", " +
                    COULMN_EMAIL +
                    " ) " +
                    "VALUES('Chunyue', 123455, 'cma01@wes')");
            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    " (" + COULMN_NAME + ", " +
                    COULMN_PHONE + ", " +
                    COULMN_EMAIL +
                    " ) " +
                    "VALUES('Joe', 123457, 'joe01@wes')");
            statement.execute("INSERT INTO " + TABLE_CONTACTS +
                    " (" + COULMN_NAME + ", " +
                    COULMN_PHONE + ", " +
                    COULMN_EMAIL +
                    " ) " +
                    "VALUES('Alex', 123237, 'alex01@wes')");
            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " +
                    COULMN_PHONE + "=5566789" +
                    " WHERE " + COULMN_NAME + "='Joe'");
            statement.execute("DELETE FROM " +TABLE_CONTACTS +
                    " WHERE " + COULMN_NAME + "='Alex'");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(COULMN_NAME) + " " +
                        resultSet.getInt(COULMN_PHONE) + " " +
                        resultSet.getString(COULMN_EMAIL));
            }
        } catch (SQLException e) {
            System.out.println("Errors happened" + e);
        }

    }
}
