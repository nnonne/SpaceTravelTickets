package services;

import entities.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class PlanetCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    public void create(String id, String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Planet planet = new Planet();
        planet.setName(name);
        planet.setId(id);
        session.persist(planet);
        transaction.commit();
        session.close();
    }

    public Planet getById(String id) {
        Session session = sessionFactory.openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }

    public void update(String id, String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        planet.setName(name);
        session.persist(planet);
        transaction.commit();
        session.close();
    }

    public void deleteById(String id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        session.remove(planet);
        transaction.commit();
        session.close();
    }

    public List<Planet> listAll() {
        Session session = sessionFactory.openSession();
        List<Planet> planetList = session.createQuery("from entities.Planet", Planet.class).list();
        session.close();
        return planetList;
    }
}
