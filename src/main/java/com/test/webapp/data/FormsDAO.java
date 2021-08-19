package com.test.webapp.data;

import com.test.webapp.model.Form;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormsDAO implements DAO<Form> {

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
        PreparedStatement ps = dbConnector.getPreparedStatement("INSERT INTO " +
                "forms(course_id, trainer_id, student_id, date) VALUES (?, ?, ?, ?)");
        try {
            ps.setInt(1, Integer.parseInt(array[0]));
            ps.setInt(2, Integer.parseInt(array[1]));
            ps.setInt(3, Integer.parseInt(array[2]));
            ps.setString(4, array[3]);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {
        PreparedStatement ps = dbConnector.getPreparedStatement("UPDATE forms " +
                "SET course_id = ?, trainer_id = ?, student_id = ?, date = ? WHERE form_id = ?");
        try {
            ps.setInt(1, Integer.parseInt(array[1]));
            ps.setInt(2, Integer.parseInt(array[2]));
            ps.setInt(3, Integer.parseInt(array[3]));
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
        dbConnector.execute("DELETE FROM forms WHERE form_id = " + id + ";");
    }

}
