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

    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {
        int student_id = Integer.parseInt(array[0]);
        dbConnector.execute("UPDATE students SET first_name_ed = '" + array[1] +
                "', last_name_ed = '" + array[2] +
                "', phone_ed = '" + array[3] +
                "', email_ed = '" + array[4] +
                "' WHERE student_id = " + student_id + ";");
    }

    @Override
    public void delete(DBConnector dbConnector, int id) {

    }
}
