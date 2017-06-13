package ru.cinimex.learn.MY.entity;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerType)) return false;

        CustomerType that = (CustomerType) o;

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
