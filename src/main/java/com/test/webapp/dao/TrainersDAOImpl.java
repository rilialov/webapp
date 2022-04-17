package com.test.webapp.dao;

import com.test.webapp.entity.Trainer;
import com.test.webapp.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TrainersDAOImpl implements TrainersDAO<Trainer> {

    @Override
    public Trainer getById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Trainer.class, id);
    }

    @Override
    public List<Trainer> getAll() {
        return (List<Trainer>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Trainer").list();
    }

    @Override
    public Trainer create(Trainer trainer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(trainer);
        tx1.commit();
        session.close();
        return trainer;
    }

    @Override
    public Trainer update(Trainer trainer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(trainer);
        tx1.commit();
        session.close();
        return trainer;
    }

    @Override
    public void delete(Trainer trainer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(trainer);
        tx1.commit();
        session.close();
    }
}
