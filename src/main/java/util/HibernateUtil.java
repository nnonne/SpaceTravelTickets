package util;

import entities.Client;
import entities.Planet;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final HibernateUtil instance;
    @Getter
    private final SessionFactory sessionFactory;
    static {
        instance = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return instance;
    }

    public void close() {
        sessionFactory.close();
    }
}