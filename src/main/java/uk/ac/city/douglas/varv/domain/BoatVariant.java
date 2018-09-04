
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
    private String boatBrand;
    @Id
    private String boatModel;
    private int year;
    private String engineBrand;
    private String engineModel;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "engineBrand", referencedColumnName = "brand", insertable = false, updatable = false)
        ,
	@JoinColumn(name = "engineModel", referencedColumnName = "model", insertable = false, updatable = false)})
    private Engine engine;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "boatBrand", referencedColumnName = "brand", insertable = false, updatable = false)
        ,
	@JoinColumn(name = "boatModel", referencedColumnName = "model", insertable = false, updatable = false)})
    private Boat boat;

    @ManyToOne
    @JoinColumn(name = "customerId", insertable = false, updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "boatVariant")
    List<BoatVariantStorage> boatVariantStorages;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getBoatBrand() {
        return boatBrand;
    }

    public void setBoatBrand(String boatBrand) {
        this.boatBrand = boatBrand;
    }

    public String getBoatModel() {
        return boatModel;
    }

    public void setBoatModel(String boatModel) {
        this.boatModel = boatModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getEngineBrand() {
        return engineBrand;
    }

    public void setEngineBrand(String engineBrand) {
        this.engineBrand = engineBrand;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
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
        return "BoatVariant{" + "customerId=" + customerId + ", boatBrand=" + boatBrand + ", boatModel=" + boatModel + ", year=" + year + ", engineBrand=" + engineBrand + ", engineModel=" + engineModel + ", engine=" + engine + ", boat=" + boat + ", customer=" + customer + ", boatVariantStorages=" + boatVariantStorages + '}';
    }

}
