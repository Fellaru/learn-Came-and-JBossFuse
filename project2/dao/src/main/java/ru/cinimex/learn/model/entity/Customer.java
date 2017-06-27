package ru.cinimex.learn.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers", schema = "customer_schema")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name = "firstName", nullable = false, length = 50)
    protected String firstName;
    @Column(name = "lastName", nullable = false, length = 50)
    protected String lastName;
    @Column(name = "middleName", length = 50)
    protected String middleName;
    @Column(name = "phone", unique = true, nullable = false)
    protected Long phone;
    @Column(name = "email", length = 50)
    protected String email;
    @Column(name ="status", length = 50)
    protected String status;

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String value) {
        this.firstName = value;
        return this;
    }


    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String value) {
        this.lastName = value;
        return this;
    }


    public String getMiddleName() {
        return middleName;
    }

    public Customer setMiddleName(String value) {
        this.middleName = value;
        return this;
    }


    public Long getPhone() {
        return phone;
    }

    public Customer setPhone(Long value) {
        this.phone = value;
        return this;
    }


    public String getEmail() {
        return email;
    }

    public Customer setEmail(String value) {
        this.email = value;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer that = (Customer) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
            return false;
        if (getMiddleName() != null ? !getMiddleName().equals(that.getMiddleName()) : that.getMiddleName() != null)
            return false;
        if (getPhone() != null ? !getPhone().equals(that.getPhone()) : that.getPhone() != null) return false;
        return getEmail() != null ? getEmail().equals(that.getEmail()) : that.getEmail() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getMiddleName() != null ? getMiddleName().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }
}
