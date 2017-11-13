package ru.cinimex.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import ru.cinimex.learn.customerws.customer.CustomerType;
import ru.cinimex.learn.customerws.customer.Customers;
import ru.cinimex.learn.customerws.customer.PhoneList;

import java.util.Iterator;
import java.util.List;

/**
 * Created by efischenko on 21.06.2017.
 */
public class GetCustByPhone2 implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Object[] args = exchange.getIn().getBody(Object[].class);
        List<Long> phones = ((PhoneList) args[0]).getPhones();
        Iterator<Long> iterator = phones.iterator();
        while (iterator.hasNext()){
            Long phone = iterator.next();
            /*searchCustomer(Long);*/

        }
        exchange.getOut().setBody( new Customers());//Здесь скорее всего не сработает
    }
}