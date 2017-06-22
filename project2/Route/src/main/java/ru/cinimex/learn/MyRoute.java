package ru.cinimex.learn;

import org.apache.camel.builder.RouteBuilder;
import ru.cinimex.learn.dao.ICustomerDao;

/**
 * Created by efischenko on 20.06.2017.
 */
public class MyRoute extends RouteBuilder {
   public ICustomerDao iCustomerDao;

    public ICustomerDao getiCustomerDao() {
        return iCustomerDao;
    }

    public void setiCustomerDao(ICustomerDao iCustomerDao) {
        this.iCustomerDao = iCustomerDao;
    }

    @Override
    public void configure() throws Exception {
        from("cxf:bean:customer_ws").choice()
                .when().simple("${in.header.operationName} == 'createCustomer'").process(new CreateCustomer())
                .when().simple("${in.header.operationName} == 'getCustomerByPhone'").process(new GetCustByPhone())
                .endChoice();
                /*.to("direct-vm:phonebyfio");*/

       /* from("direct-vm:phonebyfio").to("activemq:GETPHONE.INPUT");*/
    }
}
