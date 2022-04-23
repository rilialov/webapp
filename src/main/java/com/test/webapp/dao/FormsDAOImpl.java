package com.test.webapp.dao;

import com.test.webapp.entity.Form;
import com.test.webapp.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FormsDAOImpl implements FormsDAO<Form>{
    @Override
    public Form getById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Form.class, id);
    }

    @Override
    public List<Form> getAll() {
        return (List<Form>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("From Form").list();
    }

    @Override
    public Form create(Form form) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(form);
        tx1.commit();
        session.close();
        return form;
    }

    @Override
    public Form update(Form form) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(form);
        tx1.commit();
        session.close();
        return form;
    }

    @Override
    public void delete(Form form) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(form);
        tx1.commit();
        session.close();
    }
}
