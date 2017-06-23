package ru.cinimex.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import ru.cinimex.learn.customerws.customer.CustomerType;
import ru.cinimex.learn.customerws.customer.Customers;


import java.util.List;
import java.util.Random;


/**
 * Created by efischenko on 20.06.2017.
 */
public class CreateCustomer implements Processor {

    private List<CustomerType> customers;

    @Override
    public void process(Exchange exchange) throws Exception {
        Object[] args = exchange.getIn().getBody(Object[].class);
        Customers dateForCustomer = (Customers) args[0];
        customers = dateForCustomer.getCustomers();

        for (CustomerType c : customers) {
            //TODO сделать проверку на id а то не вставиться и вернуть SoapFault(или статус eror)
            if(!isEmailValid(c.getEmail())) c.setEmail(null);
            /* c = Converter(iCustomerDao.insert(c));*/
            c.setCustomerStatus("ImitationCreate");
    }

        exchange.getOut().setBody(dateForCustomer);
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
}
