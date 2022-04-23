package com.test.webapp.dao;

import com.test.webapp.entity.Event;
import com.test.webapp.entity.Form;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class FormsDAOImplTest {

    private FormsDAOImpl formsDAO;
    private StudentsDAOImpl studentsDAO;
    private EventsDAOImpl eventsDAO;

    @BeforeEach
    void init() {
        formsDAO = new FormsDAOImpl();
    }

    @Test
    void getById() {
        Form form = formsDAO.getById(1L);

        Assertions.assertNotNull(form);
    }

    @Test
    void getAll() {
        List<Form> forms = formsDAO.getAll();

        Assertions.assertNotNull(forms);
        Assertions.assertTrue(forms.size() > 0);
    }

    @Test
    void create() {
        studentsDAO = new StudentsDAOImpl();
        eventsDAO = new EventsDAOImpl();
        Form form = new Form(studentsDAO.getById(1L), eventsDAO.getById(1L));
        Form created = formsDAO.create(form);

        formsDAO.delete(created);
        Assertions.assertNotNull(created);

    }

    @Test
    void update() {
        studentsDAO = new StudentsDAOImpl();
        eventsDAO = new EventsDAOImpl();
        Form form = new Form(studentsDAO.getById(1L), eventsDAO.getById(1L));
        Form created = formsDAO.create(form);

        Event event = eventsDAO.getById(2L);
        created.setEvent(event);
        formsDAO.update(created);

        Form updated = formsDAO.getById(created.getId());
        formsDAO.delete(updated);
        Assertions.assertEquals(2L, updated.getEvent().getId());
    }

    @Test
    void delete() {
        studentsDAO = new StudentsDAOImpl();
        eventsDAO = new EventsDAOImpl();
        Form form = new Form(studentsDAO.getById(1L), eventsDAO.getById(1L));
        Form created = formsDAO.create(form);

        formsDAO.delete(created);

        Form deleted = formsDAO.getById(created.getId());
        Assertions.assertNull(deleted);
    }
}