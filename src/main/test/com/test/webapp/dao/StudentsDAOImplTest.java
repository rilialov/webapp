package com.test.webapp.dao;

import com.test.webapp.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class StudentsDAOImplTest {

    private StudentsDAOImpl studentsDAO;

    @BeforeEach
    void init() {
        studentsDAO = new StudentsDAOImpl();
    }

    @Test
    void getById() {
        Student student = studentsDAO.getById(1L);

        Assertions.assertNotNull(student);
    }

    @Test
    void getAll() {
        List<Student> students = studentsDAO.getAll();

        Assertions.assertNotNull(students);
        Assertions.assertTrue(students.size() > 0);
    }

    @Test
    void create() {
        Student student = new Student("Name","Last Name");
        Student created = studentsDAO.create(student);

        studentsDAO.delete(created);
        Assertions.assertNotNull(created);
    }

    @Test
    void update() {
        Student student = new Student("Name","Last Name");
        Student created = studentsDAO.create(student);

        created.setFirstName("Changed Name");
        studentsDAO.update(created);

        Student updated = studentsDAO.getById(created.getId());
        studentsDAO.delete(updated);
        Assertions.assertEquals("Changed Name", updated.getFirstName());
    }

    @Test
    void delete() {
        Student student = new Student("Name","Last Name");
        Student created = studentsDAO.create(student);

        studentsDAO.delete(created);

        Student deleted = studentsDAO.getById(created.getId());
        Assertions.assertNull(deleted);
    }
}