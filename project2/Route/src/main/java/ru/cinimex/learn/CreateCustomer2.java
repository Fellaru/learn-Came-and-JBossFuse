package ru.cinimex.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cinimex.learn.customerws.customer.CustomerType;
import ru.cinimex.learn.customerws.customer.Customers;
import ru.cinimex.learn.dao.ICustomerDao;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by efischenko on 21.06.2017.
 */
public class CreateCustomer2 implements Processor {
    private static final Logger log = LoggerFactory.getLogger(CreateCustomer2.class);
    ICustomerDao iCustomerDao;


    @Override
    public void process(Exchange exchange) throws Exception {
        Object[] args = exchange.getIn().getBody(Object[].class);
        Customers dateForCustomer = (Customers) args[0];
        List<CustomerType> customers = dateForCustomer.getCustomers();
      /*  customers.forEach(customerType -> );
                (customerType ->addCustomer(customerType));*/

        Iterator<CustomerType> iterator = customers.iterator();
        while (iterator.hasNext()){
            CustomerType customerType = iterator.next();
            addCustomer(customerType);

        }
        exchange.getOut().setBody(dateForCustomer);
    }


    private void addCustomer(CustomerType customer) {

        if (!customer.getEmail().equals(null) && isEmailValid(customer.getEmail())) {
            customer.setEmail(null);
        }
        if (customer.getPhone().equals(null)) {
            try {
                customer.setPhone(getPhoneByCustomer(customer));
            } catch (Exception e) {
                //TODO Здесь особая ошибка, когда телефон не найден
                customer.setCustomerStatus("Error_Invalid_Phone");
            }
        }
        if (!customer.getCustomerStatus().contains("Error")) {
            try {
                log.info("Start Insert");
                CustomerType result =fromString(iCustomerDao.create(toStringCustomer(customer)));
                customer.setCustomerStatus(result.getCustomerStatus());
                customer.setCustomerId(result.getCustomerId());
                //TODO insert CustomerType
            } catch (Exception e) {
                customer.setCustomerStatus("Error_CannotInsert");
                log.info("Insert Failed");
            }
        }


    }

    private Long getPhoneByCustomer(CustomerType customer) {
        return new Random().nextLong();
        //TODO РАБОТА С СЕРВИСОМ GetPhoneByFIO
    }

    public boolean isEmailValid(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
        //TODO СДелать через функцию а не руками( функцию которая пойдет на fuse)
    }

    private String toStringCustomer(CustomerType customer) {
        return null;
    }
    private CustomerType fromString(String string){
        return null;
    }
}

