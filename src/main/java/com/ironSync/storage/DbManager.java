package com.ironSync.storage;

import com.ironSync.util.LoadProperties;

import java.sql.*;
import java.util.function.Consumer;

/**
 * Manages database connections and query execution.
 *
 * This class uses properties loaded from an external file to connect to the database
 * and provides methods to test the connection, execute SELECT queries, and perform
 * data modification operations (INSERT, UPDATE, DELETE).
 */
public class DbManager {

    /** Array containing database connection properties [URL, user, password] */
    private final String[] dbProperties = new LoadProperties().loadDbProperties();

    /** Database URL */
    private final String dbUrl = dbProperties[0];

    /** Database user */
    private final String dbUser = dbProperties[1];

    /** Database password */
    private final String dbPwd = dbProperties[2];

    /**
     * Tests the database connection.
     *
     * @return true if the connection is successful, false if an error occurs
     */
    public boolean testDatabaseConnection() {
        try (Connection dbConnection = DriverManager.getConnection(dbUrl, dbUser, dbPwd);) {
            System.out.println("Successfully connected to the database.");
            return true;
        } catch (Exception e) {
            System.out.println("There was an error connecting to database. More details: " + e);
            return false;
        }
    }

    /**
     * Executes a SELECT query and processes the ResultSet using a Consumer.
     *
     * @param sql the SQL query to execute
     * @param processor a Consumer to process the ResultSet; can be null
     * @param params optional parameters for the prepared statement
     * @return true if the query returned at least one row, false otherwise
     * @throws IllegalArgumentException if a SQL exception occurs
     */
    public boolean execQuery(String sql, Consumer<ResultSet> processor, Object... params) {
        try (Connection conn = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPwd);
             PreparedStatement prepStmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                int index = i + 1;
                Object param = params[i];

                switch (param) {
                    case String s -> prepStmt.setString(index, s);
                    case Integer n -> prepStmt.setInt(index, n);
                    case Double d -> prepStmt.setDouble(index, d);
                    case null -> prepStmt.setNull(index, java.sql.Types.NULL);
                    default -> prepStmt.setObject(index, param);
                }
            }

            try (ResultSet rs = prepStmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    return false;
                }

                if (processor != null) {
                    processor.accept(rs);
                }

                return true;
            }
        } catch (SQLException sqlEx) {
            throw new IllegalArgumentException("An error occurred after executing the query: " + sqlEx);
        }
    }

    /**
     * Executes an INSERT, UPDATE, or DELETE statement.
     *
     * @param sql the SQL statement to execute
     * @param params optional parameters for the prepared statement
     * @return the number of rows affected
     */
    public int execUpdate(String sql, Object... params) {
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
             PreparedStatement prepStmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                Object param = params[i];
                int index = i + 1;
                switch (param) {
                    case String s -> prepStmt.setString(index, s);
                    case Integer n -> prepStmt.setInt(index, n);
                    case Double d -> prepStmt.setDouble(index, d);
                    case null -> prepStmt.setNull(index, java.sql.Types.NULL);
                    default -> prepStmt.setObject(index, param);
                }
            }

            return prepStmt.executeUpdate();

        } catch (SQLException sqlEx) {
            System.out.println("An error occurred after executing the query: " + sqlEx);
            return 0;
        }
    }
}
