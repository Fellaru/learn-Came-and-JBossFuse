package ru.cinimex.learn.dao;


import org.junit.BeforeClass;
import org.junit.Test;
import ru.cinimex.learn.model.entity.Customer;


import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by efischenko on 13.06.2017.
 */
public class CustomerDaoTest {
    private static ICustomerDao customerDao;
    private static Customer customer;
    private static int customersBeforeTest;
    private static String firstName = "Ella";
    private static String lastName = "Fischenko";
    private static Long phone = new Random().nextLong();


@BeforeClass
public static void setUp() throws Exception {
     customerDao = new CustomerDao();
     firstName = "Lolita " + new Random().nextInt(999999);
     customer = new Customer().setFirstName(firstName).setLastName(lastName).setPhone(phone);
     customersBeforeTest = customerDao.getAll().size();
    customerDao.insert(customer);
}

    @Test
    public void getAllTest() throws Exception {
        assertTrue(customerDao.getAll().size() > 0);
    }

    @Test
    public void insertTest() throws Exception {
        assertEquals(customersBeforeTest + 1, customerDao.getAll().size());
    }
}
