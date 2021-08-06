package com.test.webapp.data;

import com.test.webapp.model.Student;

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
        dbConnector.execute("INSERT INTO students(first_name, last_name, phone, email) VALUES ('" + array[0] +
                "', '" + array[1] + "', '" + array[2] + "', '" + array[3] + "')");
    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {
        int student_id = Integer.parseInt(array[0]);
        dbConnector.execute("UPDATE students SET first_name = '" + array[1] +
                "', last_name = '" + array[2] + "', phone = '" + array[3] + "' , email = '" + array[4] +
                "' WHERE student_id = " + student_id + ";");
    }

    @Override
    public void delete(DBConnector dbConnector, int id) {
        dbConnector.execute("DELETE FROM students WHERE student_id = " + id + ";");
    }
}