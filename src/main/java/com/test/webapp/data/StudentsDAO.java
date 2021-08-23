package com.test.webapp.data;

import com.test.webapp.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsDAO implements DAO<Student> {

    @Override
    public Student get(DBConnector dbConnector, int id) {
        Student student = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM students WHERE student_id = " + id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                student = new Student(resultSet.getString(2), resultSet.getString(3));
                student.setId(resultSet.getInt(1));
                student.setPhone(resultSet.getString(4));
                student.setEmail(resultSet.getString(5));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    @Override
    public List<Student> getAll(DBConnector dbConnector) {
        ArrayList<Student> studentsList = new ArrayList<>();
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM students;");
        if (resultSet != null) {
            try {
                resultSet.next();
                while (!resultSet.isAfterLast()) {
                    Student student = new Student(resultSet.getString(2), resultSet.getString(3));
                    student.setId(resultSet.getInt(1));
                    student.setPhone(resultSet.getString(4));
                    student.setEmail(resultSet.getString(5));
                    student.setFirstName_ed(resultSet.getString(6));
                    student.setLastName_ed(resultSet.getString(7));
                    student.setPhone_ed(resultSet.getString(8));
                    student.setEmail_ed(resultSet.getString(9));
                    studentsList.add(student);
                    resultSet.next();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentsList;
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
                "SET first_name = ?, last_name = ?, phone = ?, email = ? WHERE student_id = ?");
        try {
            ps.setString(1, array[1]);
            ps.setString(2, array[2]);
            ps.setString(3, array[3]);
            ps.setString(4, array[4]);
            ps.setInt(5, Integer.parseInt(array[0]));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEdited(DBConnector dbConnector, String[] array) {
        PreparedStatement ps = dbConnector.getPreparedStatement("UPDATE students " +
                "SET first_name_ed = ?, last_name_ed = ?, phone_ed = ?, email_ed = ? WHERE student_id = ?");
        try {
            ps.setString(1, array[1]);
            ps.setString(2, array[2]);
            ps.setString(3, array[3]);
            ps.setString(4, array[4]);
            ps.setInt(5, Integer.parseInt(array[0]));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(DBConnector dbConnector, int id) {
        dbConnector.execute("DELETE FROM students WHERE student_id = " + id + ";");
    }

}