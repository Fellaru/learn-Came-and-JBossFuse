package ru.cinimex.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import ru.cinimex.learn.customerws.customer.CustomerType;
import ru.cinimex.learn.customerws.customer.Customers;
import ru.cinimex.learn.customerws.customer.PhoneList;
import ru.cinimex.learn.dao.ICustomerDao;

import java.util.Iterator;
import java.util.List;


/**
 * Created by efischenko on 20.06.2017.
 */
public class GetCustByPhone implements Processor{
    public ICustomerDao iCustomerDao;
    @Override
    public void process(Exchange exchange) throws Exception {
        Object[] args = exchange.getIn().getBody(Object[].class);
        exchange.getOut().setBody( new Customers());
    }

}
/*

    @Override
    public void process(Exchange exchange) throws Exception {
        Customers dateForCustomer = new Customers();
        List<CustomerType> customers = dateForCustomer.getCustomers();

        Object[] args = exchange.getIn().getBody(Object[].class);
        List<Long> phones = ((PhoneList) args[0]).getPhones();

        Iterator<Long> iterator = phones.iterator();
        while (iterator.hasNext()){
            Long phone = iterator.next();
            iCustomerDao.getByPhone(phone);
            CustomerType customerType = new CustomerType();
            customerType.setFirstName("Заглушка");
            customerType.setLastName("Заглушка");
            customers.add(customerType);
        }
        exchange.getOut().setBody( new Customers());
    }
*/


