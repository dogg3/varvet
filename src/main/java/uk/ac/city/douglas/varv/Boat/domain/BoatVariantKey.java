/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Boat.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author douglaslandvik
 */
public class BoatVariantKey implements Serializable {

    private int CustID;
    private int boatId;

    public int getCustID() {
        return CustID;
    }

    public void setCustID(int CustID) {
        CustID = CustID;
    }

    public int getBoatId() {
        return boatId;
    }

    public void setBoatId(int boatId) {
        this.boatId = boatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoatVariantKey that = (BoatVariantKey) o;
        return CustID == that.CustID &&
                boatId == that.boatId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(CustID, boatId);
    }


    @Override
    public String toString() {
        return "BoatVariantKey{" +
                "CustID=" + CustID +
                ", boatId=" + boatId +
                '}';
    }
}
