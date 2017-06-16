package ru.cinimex.learn;
import ru.cinimex.learn.customerws.customer.Customers;
import ru.cinimex.learn.customerws.customer.CustomersResult;
import ru.cinimex.learn.customerws.customer.PhoneList;
import ru.cinimex.learn.customerws.service.ICustomerWS;

import java.util.logging.Logger;



/**
 * Created by efischenko on 15.06.2017.
 */


@javax.jws.WebService(
        serviceName = "Customer_ServiceClient",
        portName = "CustomerWS",
        targetNamespace = "http://learn.cinimex.ru/CustomerWS/service",
        wsdlLocation = "file:/C:/Users/efischenko/Desktop/OnlyService_and_FUSE/CustomerWS/src/main/resources/wsdl/customerWS.wsdl",
        endpointInterface = "ru.cinimex.learn.customerws.service.ICustomerWS")

public class CustomerWSImpl implements ICustomerWS {

    private static final Logger LOG = Logger.getLogger(CustomerWSImpl.class.getName());


    public CustomersResult createCustomer(Customers dateForCustomer) {
        LOG.info("Executing operation createCustomer");
        System.out.println(dateForCustomer);
        try {
            ru.cinimex.learn.customerws.customer.CustomersResult _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }


    public CustomersResult getCustomerByPhone(PhoneList phoneList) {
        LOG.info("Executing operation getCustomerByPhone");
        System.out.println(phoneList);
        try {
            ru.cinimex.learn.customerws.customer.CustomersResult _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}

