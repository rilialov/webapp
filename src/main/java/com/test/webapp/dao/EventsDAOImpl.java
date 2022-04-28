package com.test.webapp.dao;

import com.test.webapp.entity.Event;
import com.test.webapp.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EventsDAOImpl implements EventsDAO<Event> {
    @Override
    public Event getById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Event.class, id);
    }

    @Override
    public List<Event> getAll() {
        return (List<Event>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("From Event").list();
    }

    @Override
    public Event create(Event event) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(event);
        tx1.commit();
        session.close();
        return event;
    }

    @Override
    public void update(Event event) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(event);
        tx1.commit();
        session.close();

    }

    @Override
    public void delete(Event event) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(event);
        tx1.commit();
        session.close();
    }
}
