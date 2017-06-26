package ru.cinimex.learn.model.converter;

import org.apache.camel.Converter;
import ru.cinimex.learn.customerws.customer.CustomerType;
import ru.cinimex.learn.model.entity.Customer;


/**
 * Created by efischenko on 21.06.2017.
 */
//TODO не могу пока проверить Converter
@Converter
public class CustomerConverter {




    @Converter
    public static Customer toCustomer(CustomerType customerType){
        //TODO Сюда можно включить условие на Error и убрать из CreateCustomer(Это мне на будущее)
        return new Customer()
                .setLastName(customerType.getLastName())
                .setFirstName(customerType.getFirstName())
                .setMiddleName(customerType.getMiddleName())
                .setPhone(customerType.getPhone())
                .setEmail(customerType.getEmail());
        //TODO Подумать насчет реализации customerStatus(Это мне на будущее)
        // Мне кажется это не нужно.setCustomerStatus(customerType.getCustomerStatus())
    }

    @Converter
    public static CustomerType toCustomerType(Customer customer){
        CustomerType customerType = new CustomerType();
        customerType.setCustomerId(customer.getId());
        customerType.setLastName(customer.getLastName());
        customerType.setFirstName(customer.getFirstName());
        customerType.setMiddleName(customer.getMiddleName());
        customerType.setPhone(customer.getPhone());
        customerType.setEmail(customer.getEmail());
        customerType.setCustomerStatus(customer.getStatus());
        return customerType;
    }
}
