package com.test.webapp.data;

import com.test.webapp.model.Form;
import com.test.webapp.model.Trainer;
import com.test.webapp.sessions.UserAccount;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBController {
    private DBConnector dbConnector = new DBConnector();

    public DBController() {
        dbConnector.setConnection();
        dbConnector.setStatement();
    }

    public UserAccount loadUser(String login) {
        UserAccount userAccount = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM users WHERE login = '" + login + "';");
        if (resultSet != null) {
            try {
                resultSet.next();
                userAccount = new UserAccount(resultSet.getString(2), resultSet.getString(3), resultSet.getBoolean(5));
                if (!userAccount.isManager()) {
                    userAccount.setForm_id(resultSet.getInt(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userAccount;
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

    public Map<Integer, Trainer> getTrainersData() {
        Map<Integer, Trainer> trainersList = new HashMap<>();
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM trainers;");
        if (resultSet != null) {
            try {
                resultSet.next();
                while (!resultSet.isAfterLast()) {
                    int id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    Trainer trainer = new Trainer(firstName, lastName);
                    trainersList.put(id, trainer);
                    resultSet.next();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return trainersList;
    }

    public void updateForm(String[] array, Form form) {
        dbConnector.execute("UPDATE students SET first_name_ed = '" + array[0] +
                "', last_name_ed = '" + array[1] +
                "', phone_ed = '" + array[2] +
                "', email_ed = '" + array[3] +
                "' WHERE student_id = " + form.getStudent_id() + ";");
    }

    public void createStudent(String[] array) {
        dbConnector.execute("INSERT INTO students(first_name, last_name, phone, email) VALUES ('" + array[0] +
                "', '" + array[1] + "', '" + array[2] + "', '" + array[3] + "')");
    }

    public void createTrainer(String[] array) {
        dbConnector.execute("INSERT INTO trainers(first_name, last_name) VALUES ('" + array[0] +
                "', '" + array[1] + "')");
    }

    public void createCourse(String[] array) {
        int vendor_id = Integer.parseInt(array[0]);
        dbConnector.execute("INSERT INTO courses(vendor_id, course_code, course_name) VALUES ('" + vendor_id +
                "', '" + array[1] + "', '" + array[2] + "')");
    }

    public void close() {
        dbConnector.close();
    }

    public DBConnector getDbConnector() {
        return dbConnector;
    }
}
