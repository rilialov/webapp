package com.test.webapp.data;

import com.test.webapp.model.Form;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FormsDAOImpl implements DAO<Form> {

    @Override
    public Form get(DBConnector dbConnector, long id) {
        Form form = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM forms WHERE form_id = " + id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                form = new Form(resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4));
                form.setId(resultSet.getInt(1));
                form.setDate(resultSet.getObject(5, LocalDate.class));
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
                    form.setDate(resultSet.getObject(5, LocalDate.class));
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
            ps.setObject(4, LocalDate.parse(array[3]));
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
            ps.setObject(4, LocalDate.parse(array[4]));
            ps.setInt(5, Integer.parseInt(array[0]));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(DBConnector dbConnector, long id) {
        dbConnector.execute("DELETE FROM forms WHERE form_id = " + id + ";");
    }

}
