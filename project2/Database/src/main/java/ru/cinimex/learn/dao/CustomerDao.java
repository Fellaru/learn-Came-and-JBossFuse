package ru.cinimex.learn.dao;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cinimex.learn.entity.Customer;

import java.util.List;

/**
 * Created by efischenko on 09.06.2017.
 */
public class CustomerDao {


    private static final Logger log = LoggerFactory.getLogger(CustomerDao.class);

    private static CustomerDao instance = new CustomerDao();

    public static CustomerDao getInstance() {
        return instance;
    }

    private CustomerDao() {
    }

    public List<Customer> getAll(Session session) {
        return session.createCriteria(Customer.class).list();
    }

    public void insert(Session session, Customer customer) {
        session.saveOrUpdate(customer);
    }

    public Customer getByPhone(Session session, Integer phone) {
        return (Customer) session
                .createQuery("from customers where phone = :phone")
                .setParameter("phone", phone)
                .uniqueResult();
    }

}
