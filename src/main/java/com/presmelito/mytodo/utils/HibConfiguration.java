package com.presmelito.mytodo.utils;

import com.presmelito.mytodo.model.Todo;
import com.presmelito.mytodo.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibConfiguration {
    private static final Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
    private static final SessionFactory sessionFactory;

    static {
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Todo.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
