package ru.cinimex.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import ru.cinimex.learn.customerws.customer.Customers;




/**
 * Created by efischenko on 20.06.2017.
 */
public class CreateCustomer implements Processor {


    @Override
    public void process(Exchange exchange) throws Exception {

        Object[] args = exchange.getIn().getBody(Object[].class);
        Customers dateForCustomer = (Customers) args[0];
        exchange.getOut().setBody(dateForCustomer);
    }
}
