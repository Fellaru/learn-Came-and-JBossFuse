package ru.cinimex.learn.dao;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.cinimex.learn.MY.entity.CustomerType;

import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private String firstName = "Ella";
	private String lastName = "Fischenko";
	private Long phone =  new Random().nextLong();


	public void testApp() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		CustomerType user = new CustomerType().setFirstName(firstName).setLastName(lastName).setPhone(phone);
		session.saveOrUpdate(user);

		session.getTransaction().commit();
		session.close();
	}
}
