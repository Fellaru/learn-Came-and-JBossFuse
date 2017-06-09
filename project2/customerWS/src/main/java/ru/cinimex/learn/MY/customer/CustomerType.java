package ru.cinimex.learn.MY.customer;


public class CustomerType {

    protected String firstName;
    protected String lastName;
    protected String middleName;
    protected Integer phone;
    protected String email;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String value) {
        this.firstName = value;
    }


    public String getLastName() {
        return lastName;
    }
    public void setLastName(String value) {
        this.lastName = value;
    }


    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String value) {
        this.middleName = value;
    }


    public Integer getPhone() {
        return phone;
    }
    public void setPhone(Integer value) {
        this.phone = value;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String value) {
        this.email = value;
    }

}
