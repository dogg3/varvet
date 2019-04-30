package uk.ac.city.douglas.varv.Account.domain;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.HashMap;

@Entity
public class Customer {

    @Id
    @Column(name="CustID",updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerID;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Tel")
    private String tel;
    @Column(name = "Email")
    private String email;
    @Column(name = "DiscountPlan")
    private String discountPlan;
    @Column(name="Town")
    private String town;
    @Column(name="Street")
    private String street;
    @Column(name="PostCode")
    private String postCode;
    @Column(name="Identifier")
    private String identifier;



    public Customer() {

    }

    public HashMap<String, String> populate(HashMap<String, String> customerData) {
        HashMap<String, String> error = new HashMap<>();
        if(customerData.get("firstName") != null) {
            this.setFirstName(customerData.get("firstName"));
        }else {
            this.setFirstName("");
            error.put("firstName","firstName");
        }
        if(customerData.get("lastName") != null) {
            this.setLastName(customerData.get("lastName"));
        }else {
            this.setLastName("");
            error.put("lastName","lastName");
        }
        if(customerData.get("tel") != null) {
            this.setTel(customerData.get("tel"));
        }else {
            this.setTel("");
            error.put("tel","tel");
        }
        if(customerData.get("email") != null) {
            this.setEmail(customerData.get("email"));
        }else {
            this.setEmail("");
            error.put("email","email");
        } 
        if(customerData.get("discountPlan") != null) {
            this.setDiscountPlan(customerData.get("discountPlan"));
        }else {
            this.setDiscountPlan("");
            error.put("discountPlan", "discountPlan");
        }
        if(customerData.get("identifier") != null) {
            this.setIdentifier(customerData.get("identifier"));
        }else {
            this.setIdentifier("");
            error.put("identifier","identifier");
        }
        if(customerData.get("street") != null) {
            this.setStreet(customerData.get("street"));
        }else {
            this.setStreet("");
            error.put("street","street");
        }
        if(customerData.get("town") != null) {
            this.setTown(customerData.get("town"));
        }else {
            this.setTown("");
            error.put("town","town");
        } if(customerData.get("postCode") != null) {
            this.setPostCode(customerData.get("postCode"));
        }else {
            this.setPostCode("");
            error.put("postCode","postCode");
        }

        return error;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiscountPlan() {
        return discountPlan;
    }

    public void setDiscountPlan(String discountPlan) {
        this.discountPlan = discountPlan;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", discountPlan='" + discountPlan + '\'' +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                ", identifier='" + identifier + '\'' +
                '}';
    }
}
