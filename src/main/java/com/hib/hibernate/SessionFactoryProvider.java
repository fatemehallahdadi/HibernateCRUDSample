package com.hib.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {


     private static SessionFactory sessionFactory;

    private static void sessionFactoryProvider()
    {

        Configuration cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();


    }

    public static SessionFactory  getSessionFactory()
    {
        if (sessionFactory == null)
            sessionFactoryProvider();

        return sessionFactory;
    }
}
