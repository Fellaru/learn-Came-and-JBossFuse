package my.experiment;

import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.TestCase;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 *
 * @author Steve Ebersole
 */
public class EntityManagerIllustrationTest extends TestCase {
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

    public void testBasicUsage() {
        // create a couple of events...
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist( new Customer().setFirstName(firstName).setLastName(lastName).setPhone(phone) );
        entityManager.getTransaction().commit();
        entityManager.close();

        /*// now lets pull events from the database and list them
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Customer> result = entityManager.createQuery( "from Cu", Customer.class ).getResultList();
        for ( Customer event : result ) {
            System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
        }
        entityManager.getTransaction().commit();
        entityManager.close();*/
    }
}
