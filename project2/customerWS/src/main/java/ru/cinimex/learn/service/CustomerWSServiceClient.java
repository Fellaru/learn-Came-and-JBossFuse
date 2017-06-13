package ru.cinimex.learn.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.5.redhat-630254
 * 2017-06-09T17:31:14.816+03:00
 * Generated source version: 3.1.5.redhat-630254
 * 
 */
@WebServiceClient(name = "customerWS_ServiceClient", 
                  wsdlLocation = "file:/C:/Users/efischenko/Desktop/efischenko-learning/customerWS/src/main/resources/wsdl/customerWS.wsdl",
                  targetNamespace = "http://ru.cinimex.learn.cinimex.ru/service")
public class CustomerWSServiceClient extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ru.cinimex.learn.cinimex.ru/service", "customerWS_ServiceClient");
    public final static QName CustomerWSPort = new QName("http://ru.cinimex.learn.cinimex.ru/service", "customerWS_Port");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/efischenko/Desktop/efischenko-learning/customerWS/src/main/resources/wsdl/customerWS.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CustomerWSServiceClient.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/efischenko/Desktop/efischenko-learning/customerWS/src/main/resources/wsdl/customerWS.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CustomerWSServiceClient(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerWSServiceClient(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerWSServiceClient() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CustomerWSServiceClient(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CustomerWSServiceClient(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CustomerWSServiceClient(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns CustomerWS
     */
    @WebEndpoint(name = "customerWS_Port")
    public CustomerWS getCustomerWSPort() {
        return super.getPort(CustomerWSPort, CustomerWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerWS
     */
    @WebEndpoint(name = "customerWS_Port")
    public CustomerWS getCustomerWSPort(WebServiceFeature... features) {
        return super.getPort(CustomerWSPort, CustomerWS.class, features);
    }

}
