package ru.cinimex.task.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * This class was generated by Apache CXF 3.1.5.redhat-630254
 * 2017-06-08T17:03:11.535+03:00
 * Generated source version: 3.1.5.redhat-630254
 * 
 */
@WebService(targetNamespace = "http://task.cinimex.ru/service", name = "HelloWorld")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface HelloWorld {

    @WebMethod
    @WebResult(name = "greeting", targetNamespace = "", partName = "greeting")
    public java.lang.String sayHi(
        @WebParam(partName = "person", name = "person", targetNamespace = "")
        java.lang.String person
    );
}
