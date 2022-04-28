package com.test.webapp.dao;

import com.test.webapp.entity.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class EventsDAOImplTest {

    private EventsDAOImpl eventsDAO;
    private CoursesDAOImpl coursesDAO;
    private TrainersDAOImpl trainersDAO;

    @BeforeEach
    void init() {
        eventsDAO = new EventsDAOImpl();
    }

    @Test
    void getById() {
        Event event = eventsDAO.getById(1L);

        Assertions.assertNotNull(event);
    }

    @Test
    void getAll() {
        List<Event> events = eventsDAO.getAll();

        Assertions.assertNotNull(events);
        Assertions.assertTrue(events.size() > 0);
    }

    @Test
    void create() {
        coursesDAO = new CoursesDAOImpl();
        trainersDAO = new TrainersDAOImpl();
        Event event = new Event(coursesDAO.getById(1L), trainersDAO.getById(1L),
                LocalDate.now());
        Event created = eventsDAO.create(event);

        eventsDAO.delete(created);
        Assertions.assertNotNull(created);
    }

    @Test
    void update() {
        coursesDAO = new CoursesDAOImpl();
        trainersDAO = new TrainersDAOImpl();
        Event event = new Event(coursesDAO.getById(1L), trainersDAO.getById(1L),
                LocalDate.now());
        Event created = eventsDAO.create(event);

        created.setDate(LocalDate.of(2022, 5, 7));
        eventsDAO.update(created);

        Event updated = eventsDAO.getById(created.getId());
        eventsDAO.delete(created);
        Assertions.assertEquals(LocalDate.of(2022, 5, 7), updated.getDate());
    }

    @Test
    void delete() {
        coursesDAO = new CoursesDAOImpl();
        trainersDAO = new TrainersDAOImpl();
        Event event = new Event(coursesDAO.getById(1L), trainersDAO.getById(1L),
                LocalDate.now());
        Event created = eventsDAO.create(event);

        eventsDAO.delete(created);

        Event deleted = eventsDAO.getById(created.getId());
        Assertions.assertNull(deleted);
    }
}