package com.test.webapp.data;

import java.sql.*;

public class DBConnector {
    private static final String DB_URL = "jdbc:postgresql://192.168.87.17:5433/Form";
    private static final String USER = "postgres";
    private static final String PASS = "123qwe";
    private static Connection connection = null;
    private static Statement statement;

    void setConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("DB driver successfully connected");
        } catch (ClassNotFoundException e) {
            System.out.println("DB driver is not found");
            return;
        }

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection to database failed");
            return;
        }

        if (connection != null) {
            System.out.println("Successfully connected to database");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }

    void setStatement() {
        if (connection != null) {
            try {
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            } catch (SQLException e) {
                System.out.println("Failed to create statement");
            }
        }
    }

    void execute(String sqlCommand) {
        try {
            statement.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            System.out.println("Failed to execute sql command");
        }
    }

    ResultSet getQuery(String sqlCommand) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sqlCommand);
            resultSet.last();
            int size = resultSet.getRow();
            resultSet.beforeFirst();
            if (size == 0) {
                resultSet = null;
            }
        } catch (SQLException e) {
            System.out.println("Failed to get query");
        }
        return resultSet;
    }

    void close() {
        if (connection != null) {
            try {
                statement.close();
                connection.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                System.out.println("Failed to close DBConnector");
            }
        }
    }
}