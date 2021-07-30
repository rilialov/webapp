package com.test.webapp.data;

import com.test.webapp.model.Trainer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainersData {
    static Trainer getTrainer(DBConnector dbConnector, int trainer_id) {
        Trainer trainer = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM trainers WHERE trainer_id = " + trainer_id + ";");

        if (resultSet != null) {
            try {
                resultSet.next();
                trainer = new Trainer(resultSet.getString(2), resultSet.getString(3));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return trainer;
    }

    public static Trainer getTrainerData(DBConnector dbConnector, int trainer_id) {
        Trainer trainer = null;
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM trainers WHERE trainer_id = " + trainer_id + ";");

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

    public static List<Trainer> getTrainersData(DBConnector dbConnector) {
        List<Trainer> trainersList = new ArrayList();
        ResultSet resultSet = dbConnector.getQuery("SELECT * FROM trainers;");
        if (resultSet != null) {
            try {
                resultSet.next();
                while (!resultSet.isAfterLast()) {
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    Trainer trainer = new Trainer(firstName, lastName);
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

    public static void updateTrainer(DBConnector dbConnector, String[] array) {
        int trainer_id = Integer.parseInt(array[0]);
        dbConnector.execute("UPDATE trainers SET first_name = '" + array[1] +
                "', last_name = '" + array[2] + "' WHERE trainer_id = " + trainer_id + ";");
    }

}
