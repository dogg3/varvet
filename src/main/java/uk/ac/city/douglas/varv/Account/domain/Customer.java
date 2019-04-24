package uk.ac.city.douglas.varv.Account.domain;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @Column(name = "CustID")
    private int customerID;

    @ManyToOne
    @JoinColumn(name="AddressPostCode", insertable = false, updatable = false)
    Address address;

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
    @Column(name = "BuildingNo")
    private String buildingNo;
    @Column(name="Identifier")
    private String identifier;

    public Customer() {

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

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", address=" + address +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", discountPlan='" + discountPlan + '\'' +
                ", buildingNo='" + buildingNo + '\'' +
                ", identifier='" + identifier + '\'' +
                '}';
    }
}
