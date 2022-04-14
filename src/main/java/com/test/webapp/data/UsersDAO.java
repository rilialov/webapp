package com.test.webapp.data;

import com.test.webapp.sessions.UserAccount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements DAO<UserAccount> {

    @Override
    public UserAccount get(DBConnector dbConnector, long id) {
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM users WHERE user_id = '" + id + "';");
        return getUserAccount(resultSet);
    }

    public UserAccount getByLogin(DBConnector dbConnector, String login) {
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM users_salt WHERE login = '" + login + "';");
        return getUserAccount(resultSet);
    }

    private UserAccount getUserAccount(ResultSet resultSet) {
        UserAccount userAccount = null;
        if (resultSet != null) {
            try {
                resultSet.next();
                userAccount = new UserAccount(resultSet.getString(2), resultSet.getString(5));
                userAccount.setHash(resultSet.getBytes(3));
                userAccount.setSalt(resultSet.getBytes(4));
                userAccount.setForm_id(resultSet.getInt(6));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userAccount;
    }

    @Override
    public List<UserAccount> getAll(DBConnector dbConnector) {
        ArrayList<UserAccount> usersList = new ArrayList<>();
        ResultSet resultSet = dbConnector.getQuery("SELECT user_id, login, users.form_id, forms.date, " +
                "students.last_name, manager FROM users LEFT JOIN forms ON users.form_id = forms.form_id " +
                "LEFT JOIN students ON forms.student_id = students.student_id;");

        if (resultSet != null) {
            try {
                resultSet.next();
                while (!resultSet.isAfterLast()) {
                    UserAccount userAccount = new UserAccount(resultSet.getString(2), resultSet.getString(6));
                    int form_id = resultSet.getInt(3);
                    userAccount.setId(resultSet.getInt(1));
                    userAccount.setForm_id(form_id);
                    if (form_id != 0) {
                        LocalDate date = resultSet.getObject(4, LocalDate.class);
                        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                        userAccount.setForm(formattedDate + " - " + resultSet.getString(5));
                    }
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

    }

    public void createWithSaltHash(DBConnector dbConnector, String[] array, byte[] salt, byte[] hash) {

        PreparedStatement ps = dbConnector.getPreparedStatement("INSERT INTO users_salt" +
                "(login, hash, salt, role) VALUES (?, ?, ?, ?)");
        try {
            ps.setString(1, array[0]);
            ps.setBytes(2, hash);
            ps.setBytes(3, salt);
            ps.setString(4, array[2]);
//            ps.setInt(5, Integer.parseInt(array[1]));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {
        PreparedStatement ps = dbConnector.getPreparedStatement("UPDATE users " +
                "SET login = ?, form_id = ?, manager = ? WHERE user_id = ?");
        try {
            ps.setString(1, array[1]);
            ps.setInt(2, Integer.parseInt(array[2]));
            ps.setBoolean(3, Boolean.parseBoolean(array[3]));
            ps.setInt(4, Integer.parseInt(array[0]));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(DBConnector dbConnector, long id) {
        dbConnector.execute("DELETE FROM users WHERE user_id = " + id + ";");
    }

    public void setHashSalt(DBConnector dbConnector, int id, byte[] salt, byte[] hash) {
        PreparedStatement ps = dbConnector.getPreparedStatement("UPDATE users SET salt = ?, hash = ? " +
                "WHERE user_id = ?");
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