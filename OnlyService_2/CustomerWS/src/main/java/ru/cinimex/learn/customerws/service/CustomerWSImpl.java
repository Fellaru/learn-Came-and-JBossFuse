package ru.cinimex.learn.customerws.service;


import java.util.logging.Logger;
import javax.jws.WebService;
import org.apache.cxf.annotations.SchemaValidation;
import ru.cinimex.learn.customerws.customer.Customers;
import ru.cinimex.learn.customerws.customer.CustomersResult;
import ru.cinimex.learn.customerws.customer.PhoneList;




@WebService(
                      serviceName = "Customer_ServiceClient",
                      portName = "CustomerWS",
                      targetNamespace = "http://learn.cinimex.ru/CustomerWS/service",
                      wsdlLocation = "file:/C:/Users/efischenko/Desktop/OnlyService_and_FUSE%20-%20копия%20-%20копия/CustomerWS/src/main/resources/wsdl/customerWS.wsdl",
                      endpointInterface = "ru.cinimex.learn.customerws.service.ICustomerWS")
@SchemaValidation
public class CustomerWSImpl implements ICustomerWS {

    private static final Logger LOG = Logger.getLogger(CustomerWSImpl.class.getName());


    public CustomersResult createCustomer(Customers dateForCustomer) {
        LOG.info("Executing operation createCustomer");
        System.out.println(dateForCustomer);
        try {
           CustomersResult _return = null;
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
            CustomersResult _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
