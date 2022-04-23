package com.test.webapp.dao;

import com.test.webapp.entity.Trainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class TrainersDAOImplTest {

    private TrainersDAOImpl trainersDAO;

    @BeforeEach
    void init() {
        trainersDAO = new TrainersDAOImpl();
    }

    @Test
    void getById() {
        Trainer trainer = trainersDAO.getById(1L);

        Assertions.assertNotNull(trainer);
    }

    @Test
    void getAll() {
        List<Trainer> trainers = trainersDAO.getAll();

        Assertions.assertNotNull(trainers);
        Assertions.assertTrue(trainers.size() > 0);
    }

    @Test
    void create() {
        Trainer trainer = new Trainer("Name", "Last Name");
        Trainer created = trainersDAO.create(trainer);

        trainersDAO.delete(created);
        Assertions.assertNotNull(created);
    }

    @Test
    void update() {
        Trainer trainer = new Trainer("Name", "Last Name");
        Trainer created = trainersDAO.create(trainer);

        created.setFirstName("Changed Name");
        trainersDAO.update(created);

        Trainer updated = trainersDAO.getById(created.getId());
        trainersDAO.delete(updated);
        Assertions.assertEquals("Changed Name", updated.getFirstName());
    }

    @Test
    void delete() {
        Trainer trainer = new Trainer("Name", "Last Name");
        Trainer created = trainersDAO.create(trainer);

        trainersDAO.delete(created);

        Trainer deleted = trainersDAO.getById(created.getId());
        Assertions.assertNull(deleted);
    }
}