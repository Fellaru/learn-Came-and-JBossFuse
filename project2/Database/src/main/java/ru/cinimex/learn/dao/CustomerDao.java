package ru.cinimex.learn.dao;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cinimex.learn.entity.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by efischenko on 09.06.2017.
 */
public class CustomerDao implements ICustomerDao{
    private static Session session ;
    private static final Logger log = LoggerFactory.getLogger(CustomerDao.class);

    public String create (String customer){
        Customer cust =new Customer();
        cust.setCustomerStatus("Create");
        return null;
        //TODO подумать насчет этого метода
    }

    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try {
            session = Database.session();
            customers= session.createCriteria(Customer.class).list();
        } catch (Exception e) {
            log.error("Ошибка 'getAll'" + e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customers;
    }


    public void insert( Customer customer){

            try {
                session = Database.session();
                session.beginTransaction();
                session.saveOrUpdate(customer);
                session.getTransaction().commit();
            } catch (Exception e) {
                log.error("Ошибка при вставке" + e);
            } finally {
                if (session != null && session.isOpen()) {

                    session.close();
                }
            }
    }


    public Customer getByPhone(Integer phone) {
        Customer customer;
        try {
            session = Database.session();
            session.beginTransaction();

            customer = (Customer) session.createQuery("from customers where phone = :phone")
                    .setParameter("phone", phone)
                    .uniqueResult();
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customer;
    }

}
