package com.test.webapp.data;

import com.test.webapp.model.Trainer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainersDAO implements DAO<Trainer> {

    @Override
    public Trainer get(DBConnector dbConnector, long id) {
        Trainer trainer = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM trainers WHERE trainer_id = " + id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                trainer = new Trainer(resultSet.getString(2), resultSet.getString(3));
                trainer.setId(resultSet.getInt(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return trainer;
    }

    @Override
    public List<Trainer> getAll(DBConnector dbConnector) {
        ArrayList<Trainer> trainersList = new ArrayList<>();
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM trainers;");
        if (resultSet != null) {
            try {
                resultSet.next();
                while (!resultSet.isAfterLast()) {
                    Trainer trainer = new Trainer(resultSet.getString(2), resultSet.getString(3));
                    trainer.setId(resultSet.getInt(1));
                    trainersList.add(trainer);
                    resultSet.next();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return trainersList;
    }

    @Override
    public void create(DBConnector dbConnector, String[] array) {
        PreparedStatement ps = dbConnector.getPreparedStatement("INSERT INTO " +
                "trainers(first_name, last_name) VALUES (?, ?)");
        try {
            ps.setString(1, array[0]);
            ps.setString(2, array[1]);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DBConnector dbConnector, String[] array) {
        PreparedStatement ps = dbConnector.getPreparedStatement("UPDATE trainers " +
                "SET first_name = ?, last_name = ? WHERE trainer_id = ?");
        try {
            ps.setString(1, array[1]);
            ps.setString(2, array[2]);
            ps.setInt(3, Integer.parseInt(array[0]));
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(DBConnector dbConnector, long id) {
        dbConnector.execute("DELETE FROM trainers WHERE trainer_id = " + id + ";");
    }
}