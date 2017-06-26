package ru.cinimex.learn;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cinimex.learn.dao.ICustomerDao;

/**
 * Created by efischenko on 20.06.2017.
 */
public class MyRoute extends RouteBuilder {




    @Override
    public void configure() throws Exception {
        from("cxf:bean:customer_ws").log(LoggingLevel.INFO,CreateCustomer.class.getName(),"Start route").choice()
                .when().simple("${in.header.operationName} == 'createCustomer'")
                         .log(LoggingLevel.INFO,CreateCustomer.class.getName(),"Start CreateCustomer").process(new CreateCustomer())
                .when().simple("${in.header.operationName} == 'getCustomerByPhone'")
                         .log(LoggingLevel.INFO,CreateCustomer.class.getName(),"Start GetCustByPhone").process(new GetCustByPhone())
                .endChoice();
                /*.to("direct-vm:phonebyfio");*/

       /* from("direct-vm:phonebyfio").to("activemq:GETPHONE.INPUT");*/
    }
}
