package com.test.webapp.data;

import com.test.webapp.sessions.UserAccount;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBController {
    private final DBConnector dbConnector = new DBConnector();

    public DBController() {
        dbConnector.setConnection();
        dbConnector.setStatement();
    }

    public UserAccount loadUser(String login) {
        UserAccount userAccount = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM users WHERE login = '" + login + "';");
        if (resultSet != null) {
            try {
                resultSet.next();
                userAccount = new UserAccount(resultSet.getString(2), resultSet.getString(3), resultSet.getBoolean(5));
                if (!userAccount.isManager()) {
                    userAccount.setForm_id(resultSet.getInt(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userAccount;
    }

    public void close() {
        dbConnector.close();
    }

    public DBConnector getDbConnector() {
        return dbConnector;
    }
}