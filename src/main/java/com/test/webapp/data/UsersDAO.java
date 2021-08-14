package com.test.webapp.data;

import com.test.webapp.sessions.UserAccount;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersDAO implements DAO<UserAccount> {
    @Override
    public UserAccount get(DBConnector dbConnector, int id) {
        UserAccount userAccount = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM users WHERE user_id = '" + id + "';");
        if (resultSet != null) {
            try {
                resultSet.next();
                char[] pass = resultSet.getString(3).toCharArray();
                userAccount = new UserAccount(resultSet.getString(2), pass, resultSet.getBoolean(5));
                if (!userAccount.isManager()) {
                    userAccount.setForm_id(resultSet.getInt(4));
                } else userAccount.setForm_id(0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userAccount;
    }

    @Override
    public List<UserAccount> getAll(DBConnector dbConnector) {
        return null;
    }

    @Override
    public void create(DBConnector dbConnector, String[] array) {

    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {

    }

    @Override
    public void delete(DBConnector dbConnector, int id) {

    }

    public UserAccount getByLogin(DBConnector dbConnector, String login) {
        UserAccount userAccount = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM users WHERE login = '" + login + "';");
        if (resultSet != null) {
            try {
                resultSet.next();
                char[] pass = resultSet.getString(3).toCharArray();
                userAccount = new UserAccount(resultSet.getString(2), pass, resultSet.getBoolean(5));
                if (!userAccount.isManager()) {
                    userAccount.setForm_id(resultSet.getInt(4));
                } else userAccount.setForm_id(0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userAccount;
    }
}
