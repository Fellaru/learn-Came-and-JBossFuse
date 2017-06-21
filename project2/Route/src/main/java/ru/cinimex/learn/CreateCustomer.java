package ru.cinimex.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import ru.cinimex.learn.customerws.customer.Customers;
import ru.cinimex.learn.dao.ICustomerDao;
import ru.cinimex.learn.entity.Customer;

import java.util.List;


/**
 * Created by efischenko on 20.06.2017.
 */
public class CreateCustomer implements Processor {
    ICustomerDao iCustomerDao = new ICustomerDao() {
        @Override
        public List<Customer> getAll() {
            return null;
        }

        @Override
        public void insert(Customer customer) {

        }

        @Override
        public Customer getByPhone(Integer phone) {
            return null;
        }
    };


    @Override
    public void process(Exchange exchange) throws Exception {
        Object[] args = exchange.getIn().getBody(Object[].class);
        Customers dateForCustomer = (Customers) args[0];
        exchange.getOut().setBody(dateForCustomer);
    }
}
