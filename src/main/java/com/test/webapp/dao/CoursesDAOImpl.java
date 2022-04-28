package com.test.webapp.dao;

import com.test.webapp.entity.Course;
import com.test.webapp.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CoursesDAOImpl implements CourseDAO<Course> {
    @Override
    public Course getById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Course.class, id);
    }

    @Override
    public List<Course> getAll() {
        return (List<Course>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("From Course").list();
    }

    @Override
    public Course create(Course course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(course);
        tx1.commit();
        session.close();
        return course;
    }

    @Override
    public void update(Course course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(course);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Course course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(course);
        tx1.commit();
        session.close();
    }
}
