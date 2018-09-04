/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.domain;

import javax.persistence.Column;
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
@IdClass(BoatVariantStorageKey.class)
@Entity
@Table(name = "Boat_variant_Storage")
public class BoatVariantStorage {

    @Id
    @Column(name = "Boat_variant_customerId")
    private int customerId;
    @Id
    @Column(name = "Boat_variant_boatbrand")
    private String boatBrand;
    @Id
    @Column(name = "Boat_variant_boatmodel")
    private String boatModel;
    @Id
    @Column(name = "Storagename")
    private String storageName;
    
      @Column(name = "start_date")
    private int startDate;
    @Column(name = "end_date")
    private int endDate;

    private String status;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "Boat_variant_boatbrand", referencedColumnName = "boatBrand", insertable = false, updatable = false)
        ,
        @JoinColumn(name = "Boat_variant_customerId", referencedColumnName = "customerId", insertable = false, updatable = false)
        ,
	@JoinColumn(name = "Boat_variant_boatmodel", referencedColumnName = "boatModel", insertable = false, updatable = false)})
    private BoatVariant boatVariant;

    @ManyToOne
    @JoinColumn(name = "storageName", referencedColumnName = "name", insertable = false, updatable = false)
    private Storage storage;

  

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public BoatVariant getBoatVariant() {
        return boatVariant;
    }

    public void setBoatVariant(BoatVariant boatVariant) {
        this.boatVariant = boatVariant;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "BoatVariantStorage{" + "customerId=" + customerId + ", boatBrand=" + boatBrand + ", boatModel=" + boatModel +  ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + '}';
    }

}
