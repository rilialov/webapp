package com.test.webapp.dao;

import com.test.webapp.entity.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CoursesDAOImplTest {

    private CoursesDAOImpl courseDAO;
    private VendorsDAOImpl vendorsDAO;

    @BeforeEach
    void init() {
        courseDAO = new CoursesDAOImpl();
    }

    @Test
    void getById() {
        Course course = courseDAO.getById(1L);

        Assertions.assertNotNull(course);
    }

    @Test
    void getAll() {
        List<Course> courses = courseDAO.getAll();

        Assertions.assertNotNull(courses);
        Assertions.assertTrue(courses.size() > 0);
    }

    @Test
    void create() {
        vendorsDAO = new VendorsDAOImpl();
        Course course = new Course("CourseCode", "CourseName", vendorsDAO.getById(1L));
        Course created = courseDAO.create(course);

        courseDAO.delete(created);
        Assertions.assertNotNull(created);
    }

    @Test
    void update() {
        vendorsDAO = new VendorsDAOImpl();
        Course course = new Course("CourseCode", "CourseName", vendorsDAO.getById(1L));
        Course created = courseDAO.create(course);

        created.setCourseCode("ChangedCode");
        created.setCourseName("ChangedName");
        courseDAO.update(created);

        Course updated = courseDAO.getById(created.getId());
        courseDAO.delete(created);
        Assertions.assertEquals("ChangedCode", updated.getCourseCode());
        Assertions.assertEquals("ChangedName", updated.getCourseName());
    }

    @Test
    void delete() {
        vendorsDAO = new VendorsDAOImpl();
        Course course = new Course("CourseCode", "CourseName", vendorsDAO.getById(1L));
        Course created = courseDAO.create(course);

        courseDAO.delete(created);

        Course deleted = courseDAO.getById(created.getId());
        Assertions.assertNull(deleted);
    }
}