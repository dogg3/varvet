///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package uk.ac.city.douglas.varv.Job.domain;
//
//import java.io.Serializable;
//
///**
// *
// * @author douglaslandvik
// */
//public class BoatVariantKey implements Serializable {
//
//    private int customerId;
//   private int boatId;
//
//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }
//
//    public int getBoatId() {
//        return boatId;
//    }
//
//    public void setBoatId(int boatId) {
//        this.boatId = boatId;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 67 * hash + this.customerId;
//        hash = 67 * hash + this.boatId;
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final BoatVariantKey other = (BoatVariantKey) obj;
//        if (this.customerId != other.customerId) {
//            return false;
//        }
//        if (this.boatId != other.boatId) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "BoatVariantKey{" + "customerId=" + customerId + ", boatId=" + boatId + '}';
//    }
//
//
//
//
//}
