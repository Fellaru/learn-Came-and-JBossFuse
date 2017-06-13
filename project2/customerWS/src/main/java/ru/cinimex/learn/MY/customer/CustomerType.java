package ru.cinimex.learn.MY.customer;

import javax.persistence.*;

@Entity
@Table( name = "customers", schema = "customer_schema" )
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name = "firstName", nullable = false, length = 50)
    protected String firstName;
    @Column(name = "lastName", nullable = false, length = 50)
    protected String lastName;
    @Column(name = "middleName",  length = 50)
    protected String middleName;
    @Column(name = "phone", unique = true, nullable = false)
    protected Long phone;
    @Column(name = "email", length = 50)
    protected String email;

    public CustomerType() {
    }

    public String getFirstName() {
        return firstName;
    }
    public CustomerType setFirstName(String value) {
        this.firstName = value;
        return this;
    }


    public String getLastName() {
        return lastName;
    }
    public CustomerType setLastName(String value) {
        this.lastName = value;
        return this;
    }


    public String getMiddleName() {
        return middleName;
    }
    public CustomerType setMiddleName(String value) {
        this.middleName = value;
        return this;
    }


    public Long getPhone() {
        return phone;
    }
    public CustomerType setPhone(Long value) {
        this.phone = value;
        return this;
    }


    public String getEmail() {
        return email;
    }
    public CustomerType setEmail(String value) {
        this.email = value;
        return this;
    }

    public Integer getId() {
        return id;
    }
}
