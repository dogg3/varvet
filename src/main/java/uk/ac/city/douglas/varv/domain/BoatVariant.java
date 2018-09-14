
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author douglaslandvik
 */
@IdClass(BoatVariantKey.class)
@Entity
@Table(name = "boat_variant")
public class BoatVariant {

    @Id
    private int customerId;
    @Id
    private int boatId;
    private int year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "boatId", insertable = false, updatable = false)
    private Boat boat;

    @ManyToOne
    @JoinColumn(name = "customerId", insertable = false, updatable = false)
    private Customer customer;



    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBoatId() {
        return boatId;
    }

    public void setBoatId(int boatId) {
        this.boatId = boatId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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

    @Override
    public String toString() {
        return "BoatVariant{" + "customerId=" + customerId + ", boatId=" + boatId + ", year=" + year + ", description=" + description + ", boat=" + boat + ", customer=" + customer + '}';
    }



  

 
   

}
