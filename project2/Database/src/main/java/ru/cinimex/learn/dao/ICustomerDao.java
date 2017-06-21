package ru.cinimex.learn.dao;


import ru.cinimex.learn.entity.Customer;

import java.util.List;

/**
 * Created by efischenko on 16.06.2017.
 */
 public interface ICustomerDao {
     public String create (String customer);
     //TODO подумать насчет этого метода

    public List<Customer> getAll();

    public void insert( Customer customer);

    public Customer getByPhone(Integer phone);
}
