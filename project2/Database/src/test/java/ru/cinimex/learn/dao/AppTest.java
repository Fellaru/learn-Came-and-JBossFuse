package ru.cinimex.learn.dao;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.cinimex.learn.model.entity.Customer;


import java.util.Random;


public class AppTest extends TestCase {
    private String firstName = "Ella";
    private String lastName = "Fischenko";
    private Long phone =  new Random().nextLong();


    public void testApp() {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Customer user = new Customer().setFirstName(firstName).setLastName(lastName).setPhone(phone);
        session.saveOrUpdate(user);

        session.getTransaction().commit();
        session.close();
    }
}