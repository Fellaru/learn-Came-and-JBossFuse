package ru.cinimex.learn;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by efischenko on 20.06.2017.
 */
public class MyRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("cxf:bean:customer_ws").choice()
                .when().simple("${in.header.operationName} == 'createCustomer'").process(new CreateCustomer())
                .when().simple("${in.header.operationName} == 'getCustomerByPhone'").process(new GetCustByPhone()).endChoice();

    }
}
