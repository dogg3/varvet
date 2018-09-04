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
public class BoatVariantKey {
    
    private int customerId;
    private String boatBrand;
    private String boatModel;

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
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.customerId;
        hash = 31 * hash + Objects.hashCode(this.boatBrand);
        hash = 31 * hash + Objects.hashCode(this.boatModel);
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
        final BoatVariantKey other = (BoatVariantKey) obj;
        if (this.customerId != other.customerId) {
            return false;
        }
        if (!Objects.equals(this.boatBrand, other.boatBrand)) {
            return false;
        }
        if (!Objects.equals(this.boatModel, other.boatModel)) {
            return false;
        }
        return true;
    }
    
    
    
}
