///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package uk.ac.city.douglas.varv.Job.domain;
//
///**
// *
// * @author douglaslandvik
// */
//public class BoatVariantEngineKey {
//
//    private int customerId;
//    private int boatId;
//    private int engineId;
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
//    public int getEngineId() {
//        return engineId;
//    }
//
//    public void setEngineId(int engineId) {
//        this.engineId = engineId;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 71 * hash + this.customerId;
//        hash = 71 * hash + this.boatId;
//        hash = 71 * hash + this.engineId;
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
//        final BoatVariantEngineKey other = (BoatVariantEngineKey) obj;
//        if (this.customerId != other.customerId) {
//            return false;
//        }
//        if (this.boatId != other.boatId) {
//            return false;
//        }
//        if (this.engineId != other.engineId) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "BoatVariantEngineKey{" + "customerId=" + customerId + ", boatId=" + boatId + ", engineId=" + engineId + '}';
//    }
//
//
//}
