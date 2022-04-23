package com.test.webapp.dao;

import com.test.webapp.entity.Vendor;
import com.test.webapp.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class VendorsDAOImpl implements VendorsDAO<Vendor> {

    @Override
    public Vendor getById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Vendor.class, id);
    }

    @Override
    public List<Vendor> getAll() {
        return (List<Vendor>) HibernateSessionFactoryUtil.getSessionFactory()
                .openSession().createQuery("From Vendor").list();
    }

    @Override
    public Vendor create(Vendor vendor) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(vendor);
        tx1.commit();
        session.close();
        return vendor;
    }

    @Override
    public Vendor update(Vendor vendor) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(vendor);
        tx1.commit();
        session.close();
        return vendor;
    }

    @Override
    public void delete(Vendor vendor) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(vendor);
        tx1.commit();
        session.close();
    }
}
