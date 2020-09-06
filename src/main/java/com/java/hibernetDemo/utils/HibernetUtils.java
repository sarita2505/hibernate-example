package com.java.hibernetDemo.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernetUtils {
    private static SessionFactory factory;

    private static SessionFactory buildSessionFactory(){

        try {
            Configuration configuration=new Configuration();
            configuration.configure("hibernet.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).build();
            System.out.println("hibernet service registry created");
            SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }catch (Throwable throwable){
            System.out.println("initial session created");
            throw new ExceptionInInitializerError(throwable);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (factory==null){
            factory=buildSessionFactory();
        }
        return factory;
    }
}
