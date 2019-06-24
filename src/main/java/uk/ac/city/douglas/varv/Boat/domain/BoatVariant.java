
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Boat.domain;

import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Job.domain.Job;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author douglaslandvik
 */

@Entity
@Table(name = "CustomerBoat")
public class BoatVariant {

    @Id
    @Column(name="customerBoatId",updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerBoatId;

    @Column(name="customerID")
    private int CustID;

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

    @OneToMany(mappedBy = "boatVariant" , fetch=FetchType.EAGER)
    private List<Job> jobs;

    @OneToMany(mappedBy = "customerBoat" , fetch=FetchType.EAGER)
    private List<BoatStorage> boatStorages;

    @OneToMany(mappedBy = "boatVariant" , fetch=FetchType.EAGER)
    private List<BoatVariantEngine> boatVariantEngines;



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

        this.boatId = boat.getBoatId();
        this.CustID = customer.getCustomerID();
        return error;
    }


    public List<BoatStorage> getBoatStorages() {
        return boatStorages;
    }

    public void setBoatStorages(List<BoatStorage> boatStorages) {
        this.boatStorages = boatStorages;
    }

    public int getCustomerBoatId() {
        return customerBoatId;
    }

    public void setCustomerBoatId(int customerBoatId) {
        this.customerBoatId = customerBoatId;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
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

    public List<BoatVariantEngine> getBoatVariantEngines() {
        return boatVariantEngines;
    }

    public void setBoatVariantEngines(List<BoatVariantEngine> boatVariantEngines) {
        this.boatVariantEngines = boatVariantEngines;
    }

    @Override
    public String toString() {
        return "BoatVariant{" +
                "customerBoatId=" + customerBoatId +
                ", CustID=" + CustID +
                ", boatId=" + boatId +
                ", year='" + year + '\'' +
                ", description='" + description + '\'' +
                ", boat=" + boat +
                ", customer=" + customer +
                '}';
    }
}
