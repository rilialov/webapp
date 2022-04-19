package com.test.webapp.data;

import com.test.webapp.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAOImpl implements DAO<Student> {

    @Override
    public Student get(DBConnector dbConnector, long id) {

        return null;
    }

    @Override
    public List<Student> getAll(DBConnector dbConnector) {

        return null;
    }

    @Override
    public void create(DBConnector dbConnector, String[] array) {
        PreparedStatement ps = dbConnector.getPreparedStatement("INSERT INTO " +
                "students(first_name, last_name, phone, email) VALUES (?, ?, ?, ?)");
        try {
            ps.setString(1, array[0]);
            ps.setString(2, array[1]);
            ps.setString(3, array[2]);
            ps.setString(4, array[3]);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {
        PreparedStatement ps = dbConnector.getPreparedStatement("UPDATE students " +
                "SET first_name = ?, last_name = ?, phone = ?, email = ? WHERE id = ?");
        try {
            ps.setString(1, array[1]);
            ps.setString(2, array[2]);
            ps.setString(3, array[3]);
            ps.setString(4, array[4]);
            ps.setLong(5, Integer.parseInt(array[0]));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEdited(DBConnector dbConnector, String[] array) {
        PreparedStatement ps = dbConnector.getPreparedStatement("UPDATE students " +
                "SET first_name_ed = ?, last_name_ed = ?, phone_ed = ?, email_ed = ? WHERE id = ?");
        try {
            ps.setString(1, array[1]);
            ps.setString(2, array[2]);
            ps.setString(3, array[3]);
            ps.setString(4, array[4]);
            ps.setLong(5, Integer.parseInt(array[0]));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(DBConnector dbConnector, long id) {
        dbConnector.execute("DELETE FROM students WHERE id = " + id + ";");
    }

}