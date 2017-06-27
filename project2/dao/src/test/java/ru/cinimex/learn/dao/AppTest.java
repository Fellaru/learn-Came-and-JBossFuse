package ru.cinimex.learn.dao;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.cinimex.learn.model.entity.Customer;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Random;


public class AppTest extends TestCase {
    private String firstName = "Ella";
    private String lastName = "Fischenko";
    private Long phone =  new Random().nextLong();
    private EntityManagerFactory entityManagerFactory;

    @Override
    protected void setUp() throws Exception {
        // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
        // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
        entityManagerFactory = Persistence.createEntityManagerFactory( "NAME" );
    }

    @Override
    protected void tearDown() throws Exception {
        entityManagerFactory.close();
    }


    public void testApp() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist( new Customer().setFirstName(firstName).setLastName(lastName).setPhone(phone) );
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}