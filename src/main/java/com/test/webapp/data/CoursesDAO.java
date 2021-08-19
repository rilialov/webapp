package com.test.webapp.data;

import com.test.webapp.model.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesDAO implements DAO<Course> {

    @Override
    public Course get(DBConnector dbConnector, int id) {
        Course course = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM courses WHERE course_id = " + id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                course = new Course(resultSet.getString(3), resultSet.getString(4));
                course.setId(resultSet.getInt(1));
                course.setVendor_id(resultSet.getInt(2));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return course;
    }

    @Override
    public List<Course> getAll(DBConnector dbConnector) {
        ArrayList<Course> coursesList = new ArrayList<>();
        ResultSet resultSet = dbConnector.getQuery("SELECT course_id, vendors.vendor_name, course_code, course_name " +
                "FROM courses JOIN vendors ON courses.vendor_id = vendors.vendor_id");
        if (resultSet != null) {
            try {
                resultSet.next();
                while (!resultSet.isAfterLast()) {
                    Course course = new Course(resultSet.getString(3), resultSet.getString(4));
                    course.setId(resultSet.getInt(1));
                    course.setVendorName(resultSet.getString(2));
                    coursesList.add(course);
                    resultSet.next();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return coursesList;
    }

    @Override
    public void create(DBConnector dbConnector, String[] array) {
        PreparedStatement ps = dbConnector.getPreparedStatement("INSERT INTO " +
                "courses(vendor_id, course_code, course_name) VALUES (?, ?, ?)");
        try {
            ps.setInt(1, Integer.parseInt(array[0]));
            ps.setString(2, array[1]);
            ps.setString(3, array[2]);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {
        PreparedStatement ps = dbConnector.getPreparedStatement("UPDATE courses " +
                "SET vendor_id = ?, course_code = ?, course_name = ? WHERE course_id = ?");
        try {
            ps.setInt(1, Integer.parseInt(array[1]));
            ps.setString(2, array[2]);
            ps.setString(3, array[3]);
            ps.setInt(4, Integer.parseInt(array[0]));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(DBConnector dbConnector, int id) {
        dbConnector.execute("DELETE FROM courses WHERE course_id = " + id + ";");
    }

}