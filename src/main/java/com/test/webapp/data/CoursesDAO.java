package com.test.webapp.data;

import com.test.webapp.model.Course;

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
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM courses;");
        if (resultSet != null) {
            try {
                resultSet.next();
                while (!resultSet.isAfterLast()) {
                    Course course = new Course(resultSet.getString(3), resultSet.getString(4));
                    course.setId(resultSet.getInt(1));
                    course.setVendor_id(resultSet.getInt(2));
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
        int vendor_id = Integer.parseInt(array[0]);
        dbConnector.execute("INSERT INTO courses(vendor_id, course_code, course_name) VALUES ('" + vendor_id +
                "', '" + array[1] + "', '" + array[2] + "')");
    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {
        int course_id = Integer.parseInt(array[0]);
        dbConnector.execute("UPDATE courses SET vendor_id = '" + array[1] +
                "', course_code = '" + array[2] + "', course_name = '" + array[3]  +
                "' WHERE course_id = " + course_id + ";");
    }

    @Override
    public void delete(DBConnector dbConnector, int id) {
        dbConnector.execute("DELETE FROM courses WHERE course_id = " + id + ";");
    }
}