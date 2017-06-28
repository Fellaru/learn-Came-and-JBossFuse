package ru.cinimex.learn;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import ru.cinimex.learn.customerws.customer.CustomerType;
import ru.cinimex.learn.customerws.customer.Customers;
import ru.cinimex.learn.customerws.customer.PhoneList;
import ru.cinimex.learn.dao.CustomerDao;


import java.util.List;


/**
 * Created by efischenko on 20.06.2017.
 */
public class GetCustByPhone implements Processor {
   private static CustomerDao customerDao;
    private List<CustomerType> customers;

    @Override
    public void process(Exchange exchange) throws Exception {
        Customers dateForCustomer = new Customers();
        customers = dateForCustomer.getCustomers();


        /*Experiment*//*
        CustomerType cust = new CustomerType();
        TypeConverter tc = exchange.getContext().getTypeConverter();
        Customer convertCust = tc.convertTo(Customer.class ,cust );
        *//*Experiment*//*
        System.out.println(convertCust.toString());*/

        Object[] args = exchange.getIn().getBody(Object[].class);
        List<Long> phones = ((PhoneList) args[0]).getPhones();
        for (Long p : phones) {
            getCustomer(p);
        }
        exchange.getOut().setBody(dateForCustomer);
    }


    public void getCustomer(Long phone) {

       /* customerDao.*/
        //TODO Сделать конвертер который бы возвращал CustomerType*/
        CustomerType customerType = new CustomerType();
        customerType.setFirstName("Заглушка");
        customerType.setLastName("Заглушка");
        customers.add(customerType);
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}


/* phones.forEach(c -> getCustomer(c));*/
//TODO разобраться почему тут не работает


       /* Iterator<Long> iterator = phones.iterator();
        while (iterator.hasNext()){
            Long phone = iterator.next();
            getCustomer(phone);

        }*/
//TODO Один не верный телефон и сразу весь ответ неверный! Возможно ли сделать через SoapFault ошибку только у одного customera
/* TODO vakselrod
  Постановка насчет телефона:
  - если поле Email содержит некорректный Email - не записываем Email в БД.
	- если поле Phone пустое - шина выполняет запрос к внешнему сервису getPhoneByFIO:
		- если поле Phone получено - записываем всю запись в БД, статус создания клиента - Created.
		- если поле Phone не получено (getPhoneByFIO не вернул ответ в течение таймаута или вернул отрицательный ответ)
		    - запись в БД по этому конкретному клиенту не создается, статус создания - Error_CannotGetPhone.

  Соответственно телефон может быть как пустым, так и быть любого формата.

  Предлагаю убрать из схемы валидацию телефона:
  <xs:simpleType name="phone_type" >
        <xs:restriction base="xs:long">
            <xs:pattern value="[7-8]{1}[0-9]{10}" />
        </xs:restriction>
    </xs:simpleType>

  SoapFault означает, что весь запрос не был обработан. Частично обработать запрос и бросить SoapFault нельзя.
  В нашем случае мы прописываем статус по обработке в ответе по конкретному клиенту: Error_CannotGetPhone
*/