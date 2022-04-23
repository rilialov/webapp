package com.test.webapp.dao;

import com.test.webapp.entity.Student;
import com.test.webapp.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentsDAOImpl implements StudentsDAO<Student>{

    @Override
    public Student getById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Student.class, id);
    }

    @Override
    public List<Student> getAll() {
        return (List<Student>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("From Student").list();
    }

    @Override
    public Student create(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
        return student;
    }

    @Override
    public Student update(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student);
        tx1.commit();
        session.close();
        return student;
    }

    @Override
    public void delete(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(student);
        tx1.commit();
        session.close();
    }
}
