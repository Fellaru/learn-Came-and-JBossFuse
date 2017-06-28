package ru.cinimex.learn.dao;


import ru.cinimex.learn.model.entity.Customer;

import java.util.List;

/**
 * Created by efischenko on 27.06.2017.
 */
public interface CustomerDao {
    void add(Customer customer);
 /*   void deleteAll();*/
    List<Customer> getAll();
 /*   Customer createCustomer(Customer customer);
    Customer getCustByPhone(Long Phone);*/
}

