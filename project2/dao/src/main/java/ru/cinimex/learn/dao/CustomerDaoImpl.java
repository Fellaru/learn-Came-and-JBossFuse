package ru.cinimex.learn.dao;

import ru.cinimex.learn.model.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by efischenko on 27.06.2017.
 */
public class CustomerDaoImpl implements CustomerDao {
    private EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }


    @Override
    public void add(Customer customer) {
        em.persist(customer);
        em.flush();
    }
/*
    public void deleteAll() {
        em.createQuery("delete from Customer").executeUpdate();
        em.flush();
        *//*TODO delete from customer_schema.customers*//*
    }*/

    @Override
    public List<Customer> getAll() {
        return em.createQuery("select p from Customer p", Customer.class).getResultList();
        /*TODO select p from from customer_schema.customers*/
    }
}
