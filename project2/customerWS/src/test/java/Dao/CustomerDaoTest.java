package Dao;

import org.junit.Test;
import ru.cinimex.learn.MY.DAO.CustomerDao;
import ru.cinimex.learn.MY.DAO.Database;
import ru.cinimex.learn.MY.customer.CustomerType;

import java.util.Random;

import  org.junit.Before;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by efischenko on 13.06.2017.
 */
public class CustomerDaoTest {
    private CustomerDao customerDao;
    private String firstName;
    private CustomerType customer;
    private int customersBeforeTest;


@Before
public void setUp() throws Exception {
    Database.setUp();
     customerDao = CustomerDao.getInstance();
     firstName = "Lolita " + new Random().nextInt(999999);
     customer = new CustomerType().setFirstName(firstName);
     customersBeforeTest = customerDao.getAll(Database.session()).size();

    Database.execTransactionalConsumer(s -> customerDao.insert(s, customer));
}

    @Test
    public void getAllTest() throws Exception {
        assertTrue(customerDao.getAll(Database.session()).size() > 0);
    }

    @Test
    public void insertTest() throws Exception {
        assertEquals(customersBeforeTest + 1, customerDao.getAll(Database.session()).size());
    }
}
