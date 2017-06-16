package ru.cinimex.learn.dao;


import org.junit.BeforeClass;
import org.junit.Test;
import ru.cinimex.learn.entity.Customer;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by efischenko on 13.06.2017.
 */
public class CustomerDaoTest {
    private static CustomerDao customerDao;
    private static Customer customer;
    private static int customersBeforeTest;
    private static String firstName = "Ella";
    private static String lastName = "Fischenko";
    private static Long phone = new Random().nextLong();


@BeforeClass
public static void setUp() throws Exception {
    Database.setUp();
     customerDao = CustomerDao.getInstance();
     firstName = "Lolita " + new Random().nextInt(999999);
     customer = new Customer().setFirstName(firstName).setLastName(lastName).setPhone(phone);
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
