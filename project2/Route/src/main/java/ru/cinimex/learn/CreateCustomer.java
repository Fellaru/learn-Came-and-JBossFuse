package ru.cinimex.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cinimex.learn.customerws.customer.CustomerType;
import ru.cinimex.learn.customerws.customer.Customers;
import ru.cinimex.learn.customerws.service.CustomerWSImpl;
import ru.cinimex.learn.dao.ICustomerDao;


import java.util.List;
import java.util.Random;


/**
 * Created by efischenko on 20.06.2017.
 */
public class CreateCustomer implements Processor {
    public static ICustomerDao iCustomerDao;//TODO 11 Усли начать работать с iCustomerDao упадет(из за все той же причины)

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
            logger.info(c.toString());
            //TODO сделать проверку на id а то не вставиться и вернуть SoapFault(или статус eror)
            if(!isEmailValid(c.getEmail())) c.setEmail(null);
            /* c = Converter(iCustomerDao.insert(c));*/
            c.setCustomerStatus("ImitationCreate");
            logger.info(c.getFirstName() + c.getLastName());
    }
        logger.info(Boolean.toString(dateForCustomer == null));
        logger.info("End of CreateCustomer process");
        exchange.getOut().setBody(dateForCustomer);
        logger.info("iCustomerDao");
        logger.info(Boolean.toString(iCustomerDao == null));
        iCustomerDao.getAll();
    }

    public ICustomerDao getiCustomerDao() {
        logger.info("Calling method getiCustomerDao");
        logger.info("iCustomerDao == null ->" + Boolean.toString(iCustomerDao == null));
        return iCustomerDao;
    }

    public void setiCustomerDao(ICustomerDao iCustomerDao) {

        logger.info("Calling method setiCustomerDao");
        logger.info("iCustomerDao == null ->" + Boolean.toString(iCustomerDao == null));
        this.iCustomerDao = iCustomerDao;
        logger.info("iCustomerDao == null ->" + Boolean.toString(iCustomerDao == null));
        logger.info("End method setiCustomerDao");
    }

    private Long getPhoneByCustomer(CustomerType customer) {
        logger.info("Work with PhonebookWS ");
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
}
