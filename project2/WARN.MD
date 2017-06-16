Take care not to confuse the jaxws:endpoint element with the cxf:cxfEndpoint element, which you meet later
in this guide:
#the jaxws:endpoint element is used to integrate a WS endpoint with a Java implementation class;
#whereas the cxf:cxfEndpoint is used to integrate a WS endpoint with a Camel route.



#
#

To build a WSDL-First Web Service, you would perform the following steps:
1. Create the WSDL contract.
1. Generate the Java stub code from the WSDL contract using a WSDL-to-Java converter, ws2java. This gives you the SEI, CustomerService, and its related classes, such as Customer.
1. Write the implementation of the SEI, CustomerServiceImpl.
1. Instantiate the Web service endpoint, by adding the appropriate code to a Spring XML file.