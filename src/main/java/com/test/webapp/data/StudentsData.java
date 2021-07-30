package com.test.webapp.data;

import com.test.webapp.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsData {

    static Student getStudent(DBConnector dbConnector, int student_id) {
        Student student = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM students WHERE student_id = " + student_id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                student = new Student(resultSet.getString(2), resultSet.getString(3));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    public static Student getStudentData(DBConnector dbConnector, int student_id) {
        Student student = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM students WHERE student_id = " + student_id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                student = new Student(resultSet.getString(2), resultSet.getString(3));
                student.setId(resultSet.getInt(1));
                student.setPhone(resultSet.getLong(4));
                student.setEmail(resultSet.getString(5));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    public static List<Student> getStudentsData(DBConnector dbConnector) {
        List<Student> studentsList = new ArrayList();
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM students;");
        if (resultSet != null) {
            try {
                resultSet.next();
                while (!resultSet.isAfterLast()) {
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    Student student = new Student(firstName, lastName);
                    student.setId(resultSet.getInt(1));
                    student.setPhone(resultSet.getLong(4));
                    student.setEmail(resultSet.getString(5));
                    student.setFirstName_ed(resultSet.getString(6));
                    student.setLastName_ed(resultSet.getString(7));
                    student.setPhone_ed(resultSet.getLong(8));
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

    public static void updateStudent(DBConnector dbConnector, String[] array) {
        int student_id = Integer.parseInt(array[0]);
        dbConnector.execute("UPDATE students SET first_name = '" + array[1] +
                "', last_name = '" + array[2] + "', phone = '" + array[3] + "' , email = '" + array[4] +
                "' WHERE student_id = " + student_id + ";");
    }

}
