/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Account.domain;

import javax.persistence.*;
import java.util.HashMap;


/**
 *
 * @author douglaslandvik
 */

@Entity
public class Staff {


    @Id
    @Column(name="StaffID",updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int staffId;

    @Column(name="FirstName")
    private String firstName;
    @Column(name="LastName")
    private String lastName;
    @Column(name="Email")
    private String email;
    @Column(name="HourlyRate")
    private String hourlyRate;
    @Column(name="Tel")
    private String tel;
    @Column(name="Town")
    private String town;
    @Column(name="Street")
    private String street;
    @Column(name="PostCode")
    private String postCode;


    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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


    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", hourlyRate='" + hourlyRate + '\'' +
                ", tel='" + tel + '\'' +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    public HashMap<String, String> populate(HashMap<String, String> staffData) {

        HashMap<String, String> error = new HashMap<>();

        if(staffData.get("firstName") != null) {
            this.setFirstName(staffData.get("firstName"));
        }else {
            this.setFirstName("");
            error.put("firstName","firstName");
        }
        if(staffData.get("lastName") != null) {
            this.setLastName(staffData.get("lastName"));
        }else {
            this.setLastName("");
            error.put("lastName","lastName");
        }
        if(staffData.get("tel") != null) {
            this.setTel(staffData.get("tel"));
        }else {
            this.setTel("");
            error.put("tel","tel");
        }
        if(staffData.get("email") != null) {
            this.setEmail(staffData.get("email"));
        }else {
            this.setEmail("");
            error.put("email","email");
        }
        if(staffData.get("street") != null) {
            this.setStreet(staffData.get("street"));
        }else {
            this.setStreet("");
            error.put("street","street");
        }
        if(staffData.get("town") != null) {
            this.setTown(staffData.get("town"));
        }else {
            this.setTown("");
            error.put("town","town");
        } if(staffData.get("postCode") != null) {
            this.setPostCode(staffData.get("postCode"));
        }else {
            this.setPostCode("");
            error.put("postCode","postCode");
        }
        if(staffData.get("hourlyRate") != null) {
            this.setHourlyRate(staffData.get("hourlyRate"));
        }else {
            this.setHourlyRate("");
            error.put("hourlyRate","hourlyRate");
        }

        return error;
    }
}
