package ru.cinimex.learn.MY.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import ru.cinimex.learn.MY.customer.CustomerType;

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

    private CustomerDao(){}

    public List<CustomerType> getAll(Session session) {
        return session.createCriteria(CustomerType.class).list();
    }

    public void insert(Session session, CustomerType customer) {
        session.saveOrUpdate(customer);
    }

    public CustomerType getByName(Session session, Integer phone) {
        return (CustomerType) session
                .createQuery("from customers where phone = :phone")
                .setParameter("phone", phone)
                .uniqueResult();
    }

}
