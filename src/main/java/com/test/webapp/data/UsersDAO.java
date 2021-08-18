package com.test.webapp.data;

import com.test.webapp.sessions.UserAccount;

import java.sql.PreparedStatement;
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
                userAccount.setSalt(resultSet.getBytes(6));
                userAccount.setHash(resultSet.getBytes(7));
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

    public void createWithSaltHash(DBConnector dbConnector, String[] array, byte[] salt, byte[] hash) {
        PreparedStatement ps = dbConnector.getPreparedStatement("INSERT INTO users(login, form_id, manager, salt, hash) VALUES (?, ?, ?, ?, ?)");
        try {
            ps.setString(1, array[0]);
            ps.setInt(2, Integer.parseInt(array[1]));
            ps.setBoolean(3, Boolean.parseBoolean(array[2]));
            ps.setBytes(4, salt);
            ps.setBytes(5, hash);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {
        int user_id = Integer.parseInt(array[0]);
        dbConnector.execute("UPDATE users SET login = '" + array[1] +
                "', form_id = '" + array[2] + "', manager = '" + array[3] + "' WHERE user_id = " + user_id + ";");
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
                userAccount.setSalt(resultSet.getBytes(6));
                userAccount.setHash(resultSet.getBytes(7));
                if (!userAccount.isManager()) {
                    userAccount.setForm_id(resultSet.getInt(4));
                } else userAccount.setForm_id(0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userAccount;
    }

    public void setHashSalt(DBConnector dbConnector, int id, byte[] salt, byte[] hash) {
        PreparedStatement ps = dbConnector.getPreparedStatement("UPDATE users SET salt = ?, hash = ? WHERE user_id = ?");
        try {
            ps.setBytes(1, salt);
            ps.setBytes(2, hash);
            ps.setInt(3, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
