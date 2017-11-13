package ru.cinimex.learn;

import ru.cinimex.learn.dao.ICustomerDao;

public class Client {
    static ICustomerDao iCustomerDao;

    // Bean properties
    public ICustomerDao getICustomerDao() {
        return iCustomerDao;
    }

    public void setICustomerDao(ICustomerDao iCustomerDao) {
        this.iCustomerDao = iCustomerDao;
    }

    public void init() {
        System.out.println("OSGi client started.");
        if (iCustomerDao != null) {
            System.out.println("Calling sayHello()");
        }
    }

}