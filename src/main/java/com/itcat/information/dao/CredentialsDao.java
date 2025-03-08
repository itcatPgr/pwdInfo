package com.itcat.information.dao;

import com.itcat.information.model.СredentialsEntity;
import com.itcat.information.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CredentialsDao
{
    private SessionFactory sessionFactory;

    public CredentialsDao() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void save(СredentialsEntity credentials)
    {
        try (Session session = sessionFactory.openSession())
        {
            session.beginTransaction();
            session.save(credentials);
            session.getTransaction().commit();
        }
    }

    public СredentialsEntity findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(СredentialsEntity.class, id);
        }
    }

    public void update(СredentialsEntity credentials) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(credentials);
            session.getTransaction().commit();
        }
    }

    public void delete(СredentialsEntity credentials) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(credentials);
            session.getTransaction().commit();
        }
    }
}
