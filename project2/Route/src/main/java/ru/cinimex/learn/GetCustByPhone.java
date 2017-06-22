package ru.cinimex.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import ru.cinimex.learn.customerws.customer.CustomerType;
import ru.cinimex.learn.customerws.customer.Customers;
import ru.cinimex.learn.customerws.customer.PhoneList;
import ru.cinimex.learn.dao.ICustomerDao;

import java.util.List;


/**
 * Created by efischenko on 20.06.2017.
 */
public class GetCustByPhone implements Processor {
    public ICustomerDao iCustomerDao;
    private List<CustomerType> customers;

    @Override
    public void process(Exchange exchange) throws Exception {
        Customers dateForCustomer = new Customers();
        customers = dateForCustomer.getCustomers();

        Object[] args = exchange.getIn().getBody(Object[].class);
        List<Long> phones = ((PhoneList) args[0]).getPhones();
        for (Long p : phones) {
            getCustomer(p);
        }
        exchange.getOut().setBody(dateForCustomer);
    }


    public void getCustomer(Long phone) {
        /*iCustomerDao.getByPhone(phone);*/
        //TODO Почему возвращает NullPointerException
        //TODO Сделать конвертер который бы возвращал CustomerType
        CustomerType customerType = new CustomerType();
        customerType.setFirstName("Заглушка");
        customerType.setLastName("Заглушка");
        customers.add(customerType);
    }

    public ICustomerDao getiCustomerDao() {
        return iCustomerDao;
    }

    public void setiCustomerDao(ICustomerDao iCustomerDao) {
        this.iCustomerDao = iCustomerDao;
    }


}


/* phones.forEach(c -> getCustomer(c));*/
//TODO разобраться почему тут не работает


       /* Iterator<Long> iterator = phones.iterator();
        while (iterator.hasNext()){
            Long phone = iterator.next();
            getCustomer(phone);

        }*/
//TODO Один не верный телефон и сразу весь ответ неверный! Возможно ли сделать через SoapFault ошибку только у одного customera