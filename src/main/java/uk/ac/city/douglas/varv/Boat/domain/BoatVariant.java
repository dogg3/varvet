
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Boat.domain;

import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Boat.domain.Boat;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariantKey;

import javax.persistence.*;
import java.util.HashMap;

/**
 *
 * @author douglaslandvik
 */
@IdClass(BoatVariantKey.class)
@Entity
@Table(name = "CustomerBoat")
public class BoatVariant {

    @Id
    @Column(name="customerID")
    private int CustID;
    @Id
    @Column(name="boatID")
    private int boatId;

    private String year;

    @Column(name="comment")
    private String description;

    @ManyToOne
    @JoinColumn(name = "boatID", insertable = false, updatable = false)
    private Boat boat;

    @ManyToOne
    @JoinColumn(name = "customerID", insertable = false, updatable = false)
    private Customer customer;



    public HashMap<String, String> populate(Boat boat, Customer customer, HashMap<String, String> boatVariantData) {
        HashMap<String, String> error = new HashMap<>();

        if(boatVariantData.get("description") != null) {
            this.setDescription(boatVariantData.get("description"));
        }else {
            this.setDescription("");
            error.put("description","descri[ption");
        }
        if(boatVariantData.get("year") != null) {
            this.setYear(boatVariantData.get("year"));
        }else {
            this.setYear("");
            error.put("year","year");
        }

        this.boat = boat;
        this.customer = customer;
        return error;
    }


    public int getCustID() {
        return CustID;
    }

    public void setCustID(int custID) {
        CustID = custID;
    }

    public int getBoatId() {
        return boatId;
    }

    public void setBoatId(int boatId) {
        this.boatId = boatId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "BoatVariant{" +
                "CustID=" + CustID +
                ", boatId=" + boatId +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", boat=" + boat +
                ", customer=" + customer +
                '}';
    }
}
