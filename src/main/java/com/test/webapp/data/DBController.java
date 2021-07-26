package com.test.webapp.data;

import com.test.webapp.model.Form;
import com.test.webapp.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBController {
    private static final DBConnector dbConnector = new DBConnector();

    public DBController() {
        dbConnector.setConnection();
        dbConnector.setStatement();
    }

    public int getFormID(String login) {
        int id = 0;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM users WHERE login = '" + login + "';");
        if (resultSet != null) {
            try {
                resultSet.next();
                id = resultSet.getInt(4);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }

    int[] getFormData(int form_id) {
        int[] ids = new int[3];
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM forms WHERE form_id = " + form_id + ";");
        if (resultSet != null) {
            try {
                resultSet.next();
                ids[0] = resultSet.getInt(2);
                ids[1] = resultSet.getInt(3);
                ids[2] = resultSet.getInt(4);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ids;
    }

    String getFormDate(int form_id) {
        String date = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM forms WHERE form_id = " + form_id + ";");
        if (resultSet != null) {
            try {
                resultSet.next();
                date = resultSet.getString(5);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    String[] getCourseData(int course_id) {
        String[] courseData = new String[2];
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM courses WHERE course_id = " + course_id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                courseData[0] = resultSet.getString(3);
                courseData[1] = resultSet.getString(4);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return courseData;
    }

    String[] getTrainerData(int trainer_id) {
        String[] trainerData = new String[2];
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM trainers WHERE trainer_id = " + trainer_id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                trainerData[0] = resultSet.getString(2);
                trainerData[1] = resultSet.getString(3);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return trainerData;
    }

    String[] getStudentData(int student_id) {
        String[] studentData = new String[2];
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM students WHERE student_id = " + student_id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                studentData[0] = resultSet.getString(2);
                studentData[1] = resultSet.getString(3);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentData;
    }

    public Map<Integer, Student> getStudentsData() {
        Map<Integer, Student> studentsList = new HashMap<>();
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM students;");
        if (resultSet != null) {
            try {
                resultSet.next();
                while (!resultSet.isAfterLast()) {
                    int id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    Student student = new Student(firstName, lastName);
                    student.setFirstName_ed(resultSet.getString(6));
                    student.setLastName_ed(resultSet.getString(7));
                    student.setPhone_ed(resultSet.getLong(8));
                    student.setEmail_ed(resultSet.getString(9));
                    studentsList.put(id, student);
                    resultSet.next();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentsList;
    }

    public void updateForm(String[] array, Form form) {
        dbConnector.execute("UPDATE students SET first_name_ed = '" + array[0] +
                "', last_name_ed = '" + array[1] +
                "', phone_ed = '" + array[2] +
                "', email_ed = '" + array[3] +
                "' WHERE student_id = " + form.getStudent_id() + ";");
    }

    public void close() {
        dbConnector.close();
    }
}
