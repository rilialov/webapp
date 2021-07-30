package com.test.webapp.data;

import com.test.webapp.model.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesData {
    static Course getCourse(DBConnector dbConnector, int course_id) {
        Course course = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM courses WHERE course_id = " + course_id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                course = new Course(resultSet.getString(3), resultSet.getString(4));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return course;
    }

    public static Course getCourseData(DBConnector dbConnector, int course_id) {
        Course course = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM courses WHERE course_id = " + course_id + ";");

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

    public static List<Course> getCoursesData(DBConnector dbConnector) {
        List<Course> coursesList = new ArrayList();
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM courses;");
        if (resultSet != null) {
            try {
                resultSet.next();
                while (!resultSet.isAfterLast()) {
                    String courseCode = resultSet.getString(3);
                    String courseName = resultSet.getString(4);
                    Course course = new Course(courseCode, courseName);
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

    public static void updateCourse(DBConnector dbConnector, String[] array) {
        int course_id = Integer.parseInt(array[0]);
        dbConnector.execute("UPDATE courses SET vendor_id = '" + array[1] +
                "', course_code = '" + array[2] + "', course_name = '" + array[3]  +
                "' WHERE course_id = " + course_id + ";");
    }

}
