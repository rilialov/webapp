package com.test.webapp.data;

import com.test.webapp.model.Form;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormDAO implements DAO<Form> {

    @Override
    public Form get(DBConnector dbConnector, int id) {
        Form form = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM forms WHERE form_id = " + id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                form = new Form(resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4));
                form.setId(resultSet.getInt(1));
                form.setDate(resultSet.getString(5));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return form;
    }

    @Override
    public List<Form> getAll(DBConnector dbConnector) {
        ArrayList<Form> formsList = new ArrayList<>();
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM forms;");
        if (resultSet != null) {
            try {
                resultSet.next();
                while (!resultSet.isAfterLast()) {
                    Form form = new Form(resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4));
                    form.setId(resultSet.getInt(1));
                    form.setDate(resultSet.getString(5));
                    formsList.add(form);
                    resultSet.next();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return formsList;
    }

    @Override
    public void create(DBConnector dbConnector, String[] array) {
        dbConnector.execute("INSERT INTO forms(course_id, trainer_id, student_id, date) VALUES ('" + array[0] +
                "', '" + array[1] + "', '" + array[2] + "', '" + array[3] + "')");
    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {
        int form_id = Integer.parseInt(array[0]);
        dbConnector.execute("UPDATE forms SET course_id = '" + array[1] +
                "', trainer_id = '" + array[2] +
                "', student_id = '" + array[3] +
                "', date = '" + array[4] +
                "' WHERE form_id = " + form_id + ";");
    }

    @Override
    public void delete(DBConnector dbConnector, int id) {

    }
}
