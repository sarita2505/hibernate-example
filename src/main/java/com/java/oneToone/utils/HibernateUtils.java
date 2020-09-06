package com.java.oneToone.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
    public static SessionFactory sessionFactory;
    public static SessionFactory buildSessionFactory(){
        try{
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.contxn.cfg.xml");
        System.out.println("Hibernate Configuration loaded");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate serviceRegistry created");

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }
        catch (Throwable ex) {
        System.err.println("Initial SessionFactory creation failed." + ex);
        ex.printStackTrace();
        throw new ExceptionInInitializerError(ex);
    }
}

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}

