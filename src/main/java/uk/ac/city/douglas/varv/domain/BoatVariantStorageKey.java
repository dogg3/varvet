/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.domain;

import java.util.Objects;

/**
 *
 * @author douglaslandvik
 */
public class BoatVariantStorageKey {
    private int customerId;
    private String boatBrand;
    private String boatModel;
    private String storageName;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.customerId;
        hash = 53 * hash + Objects.hashCode(this.boatBrand);
        hash = 53 * hash + Objects.hashCode(this.boatModel);
        hash = 53 * hash + Objects.hashCode(this.storageName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BoatVariantStorageKey other = (BoatVariantStorageKey) obj;
        if (this.customerId != other.customerId) {
            return false;
        }
        if (!Objects.equals(this.boatBrand, other.boatBrand)) {
            return false;
        }
        if (!Objects.equals(this.boatModel, other.boatModel)) {
            return false;
        }
        if (!Objects.equals(this.storageName, other.storageName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BoatVariantStorageKey{" + "customerId=" + customerId + ", boatBrand=" + boatBrand + ", boatModel=" + boatModel + ", storageName=" + storageName + '}';
    }

    
    
}
