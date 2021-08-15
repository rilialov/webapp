package com.test.webapp.data;

import com.test.webapp.sessions.UserAccount;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements DAO<UserAccount> {
    @Override
    public UserAccount get(DBConnector dbConnector, int id) {
        UserAccount userAccount = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM users WHERE user_id = '" + id + "';");
        if (resultSet != null) {
            try {
                resultSet.next();
                userAccount = new UserAccount(resultSet.getString(2), resultSet.getBoolean(5));
                userAccount.setPassword(resultSet.getString(3).toCharArray());
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
        ArrayList<UserAccount> usersList = new ArrayList<>();
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM users;");

        if (resultSet != null) {
            try {
                resultSet.next();
                while (!resultSet.isAfterLast()) {
                    UserAccount userAccount = new UserAccount(resultSet.getString(2), resultSet.getBoolean(5));
                    if (!userAccount.isManager()) {
                        userAccount.setForm_id(resultSet.getInt(4));
                    } else userAccount.setForm_id(0);
                    userAccount.setId(resultSet.getInt(1));
                    usersList.add(userAccount);
                    resultSet.next();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usersList;
    }

    @Override
    public void create(DBConnector dbConnector, String[] array) {
        dbConnector.execute("INSERT INTO users(login, pass, form_id, manager) VALUES ('" + array[0] +
                "', '" + array[1] + "' , '" + array[2] + "', '" + array[3] + "')");
    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {
        int user_id = Integer.parseInt(array[0]);
        dbConnector.execute("UPDATE users SET login = '" + array[1] +
                "', pass = '" + array[2] + "', form_id = '" + array[3] + "', manager = '" + array[4] +
                "' WHERE user_id = " + user_id + ";");
    }

    @Override
    public void delete(DBConnector dbConnector, int id) {
        dbConnector.execute("DELETE FROM users WHERE user_id = " + id + ";");
    }

    public UserAccount getByLogin(DBConnector dbConnector, String login) {
        UserAccount userAccount = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM users WHERE login = '" + login + "';");
        if (resultSet != null) {
            try {
                resultSet.next();
                userAccount = new UserAccount(resultSet.getString(2), resultSet.getBoolean(5));
                userAccount.setPassword(resultSet.getString(3).toCharArray());
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
