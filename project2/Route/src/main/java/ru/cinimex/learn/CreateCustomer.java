package ru.cinimex.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cinimex.learn.customerws.customer.CustomerType;
import ru.cinimex.learn.customerws.customer.Customers;
import ru.cinimex.learn.customerws.service.CustomerWSImpl;
import ru.cinimex.learn.dao.CustomerDao;


import java.util.List;
import java.util.Random;


/**
 * Created by efischenko on 20.06.2017.
 */
public class CreateCustomer implements Processor {
    public static CustomerDao customerDao;


    private List<CustomerType> customers;

    private ru.cinimex.learn.customerws.service.ICustomerWS abc;
    private static Logger logger = LoggerFactory.getLogger(CreateCustomer.class);

    @Override
    public void process(Exchange exchange) throws Exception {

        logger.info("Create CustomerWSImpl");
        abc = new CustomerWSImpl();
        abc.createCustomer(new Customers());
        logger.info("Start work with Exchenge");

        Object[] args = exchange.getIn().getBody(Object[].class);
        Customers dateForCustomer = (Customers) args[0];

        customers = dateForCustomer.getCustomers();
        logger.info("Start work with List<CustomerType> customers");
        for (CustomerType c : customers) {
            logger.info("inside");
            logger.info("inside");
            logger.info(Boolean.toString(c == null));
            logger.info(c.toString());
            //TODO сделать проверку на id а то не вставиться и вернуть SoapFault(или статус eror)
            logger.info("inside");
            if(!isEmailValid(c.getEmail())) c.setEmail(null);
            logger.info("1");
            c.setCustomerStatus("ImitationCreate");
            logger.info("2");
            logger.info(c.getFirstName() + c.getLastName());
            logger.info("3");
    }
        logger.info(Boolean.toString(dateForCustomer == null));
        logger.info("End of CreateCustomer process");
        exchange.getOut().setBody(dateForCustomer);
        logger.info("iCustomerDao");
        logger.info(Boolean.toString(customerDao == null));
        customerDao.getAll();
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        logger.info("Calling method setCustomerDao");
        logger.info("CustomerDao == null ->" + Boolean.toString(customerDao == null));
        this.customerDao = customerDao;
        logger.info("iCustomerDao == null ->" + Boolean.toString(customerDao == null));
        logger.info("End method setiCustomerDao");

    }

    private Long getPhoneByCustomer(CustomerType customer) {
        logger.info("Work with PhonebookWS ");
        return new Random().nextLong();
        //TODO РАБОТА С СЕРВИСОМ GetPhoneByFIO
    }

    public boolean isEmailValid(String email) {
        /*String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);m.matches();*/
        return true;
        //TODO СДелать через функцию а не руками( функцию которая пойдет на fuse)
    }
}
