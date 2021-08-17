package com.test.webapp.data;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnector {
    private static String DB_URL;
    private static String USER;
    private static String PASS;
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

        loadProperties();

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

    PreparedStatement getPreparedStatement(String sqlCommand) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlCommand);
        } catch (SQLException e) {
            System.out.println("Failed to create statement");
        }
        return ps;
    }

    private static void loadProperties() {
        InputStream in = DBConnector.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DB_URL = properties.getProperty("url");
        USER = properties.getProperty("user");
        PASS = properties.getProperty("pass");
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