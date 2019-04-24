package uk.ac.city.douglas.varv.Account.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Address {

    @Id
    @Column(name = "PostCode")
    private String postCode;
    @Column(name = "Town")
    private String town;
    @Column(name = "City")
    private String city;
    @Column(name = "Street")
    private String street;

    @OneToMany(mappedBy = "address")
    List<Staff> staffList;


    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }


    @Override
    public String toString() {
        return "Address{" +
                "postCode='" + postCode + '\'' +
                ", town='" + town + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", staffList=" + staffList +
                '}';
    }
}