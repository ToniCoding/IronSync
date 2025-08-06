package com.ironSync.storage;

import com.ironSync.util.LoadProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;

public class DbManager {
    private final String[] dbProperties = new LoadProperties().loadDbProperties();

    private final String dbUrl = dbProperties[0];
    private final String dbUser = dbProperties[1];
    private final String dbPwd = dbProperties[2];

    public boolean testDatabaseConnection() {
        try (Connection dbConnection = DriverManager.getConnection(dbUrl, dbUser, dbPwd);) {
            System.out.println("Successfully connected to the database.");
            return true;
        } catch (Exception e) {
            System.out.println("There was an error connecting to database. More details: " + e);
            return false;
        }
    }

    public void execQuery(String sql, Consumer<ResultSet> processor) {
        try {
            Connection dbConnection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPwd);
            Statement sqlStmt = dbConnection.createStatement();
            ResultSet returnedData = sqlStmt.executeQuery(sql);

            processor.accept(returnedData);
        } catch (SQLException sqlEx) {
            System.out.println("An error occurred after executing the query: " + sqlEx);
        }
    }
}
