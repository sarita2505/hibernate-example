package com.java.oneTomany.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private static SessionFactory factory;


    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("oneTomany/hibernate.cfg.xml");
            System.out.println("configuration file is loaded");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("service registry is loaded");
            factory = configuration.buildSessionFactory(serviceRegistry);
            return factory;
        } catch (Throwable ex) {
            System.out.println("initial session factory is failed to create");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getFactory() {
        if (factory == null)
            factory = buildSessionFactory();
        return factory;
    }
}
