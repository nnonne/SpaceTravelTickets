package services;

import entities.Client;
import entities.Planet;
import entities.Ticket;

import util.HibernateUtil;


import org.hibernate.PropertyValueException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.List;

public class TicketCrudService {
    //private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    private static TicketCrudService instance;
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public static TicketCrudService getInstance() {
        if (instance == null) {
            synchronized (TicketCrudService.class) {
                if (instance == null) {
                    instance = new TicketCrudService();
                }
            }
        }
        return instance;
    }
    public void create(Client client, Planet fromPlanet, Planet toPlanet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Ticket ticket = new Ticket();
            ticket.setClient(client);
            ticket.setFromPlanet(fromPlanet);
            ticket.setToPlanet(toPlanet);
            session.persist(ticket);
            transaction.commit();
        } catch (PropertyValueException e) {
            //e.printStackTrace();
            System.out.println("One of parameters is null");
        }
    }

    public Ticket getById(long id) {
        Session session = sessionFactory.openSession();
        Ticket ticket = session.get(Ticket.class, id);
        session.close();
        return ticket;
    }

    public void update(Client client, long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        ticket.setClient(client);
        session.update(ticket);
        transaction.commit();
        session.close();
    }

    public void delete(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        session.remove(ticket);
        transaction.commit();
        session.close();
    }

    public List<Ticket> listAll() {
        Session session = sessionFactory.openSession();
        List<Ticket> ticketList = session.createQuery("from entities.Ticket", Ticket.class).list();
        session.close();
        return ticketList;
    }
}