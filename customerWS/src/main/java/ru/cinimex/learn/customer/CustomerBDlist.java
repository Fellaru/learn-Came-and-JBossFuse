
package ru.cinimex.learn.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerBDlist complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerBDlist"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="customerBD" type="{http://learn.cinimex.ru/customer}customerBD_type"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerBDlist", propOrder = {
    "customerBD"
})
public class CustomerBDlist {

    @XmlElement(required = true)
    protected CustomerBDType customerBD;

    /**
     * Gets the value of the customerBD property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerBDType }
     *     
     */
    public CustomerBDType getCustomerBD() {
        return customerBD;
    }

    /**
     * Sets the value of the customerBD property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerBDType }
     *     
     */
    public void setCustomerBD(CustomerBDType value) {
        this.customerBD = value;
    }

}
