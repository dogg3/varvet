///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package uk.ac.city.douglas.varv.Job.domain;
//
//import uk.ac.city.douglas.varv.Account.domain.Customer;
//
//import java.sql.Date;
//import java.util.List;
//import javax.persistence.*;
//
//
///**
// *
// * @author douglaslandvik
// */
//
//@Entity
//public class Job {
//
////    @ManyToOne
////    @JoinColumn(name = "VehicleRegNo", insertable = false, updatable = false)
////    private Vehicle  vehicle;
//
//    @ManyToOne
//    @JoinColumn(name = "CustomerID", insertable = false, updatable = false)
//    private Customer customer;
//
//    @Id
//    @Column(name="JobNo")
//    private int jobId;
//    @Column(name="VehicleRegNo")
//    private String vehicleRegNo;
//    @Column(name="StaffStaffID")
//    private String staffID;
//    @Column(name="DateBooked")
//    private Date dateBooked;
//    @Column(name="JobType")
//    private String jobType;
//    @Column(name="Status")
//    private String status;
//    @Column(name="ActualTime")
//    private String actualTime;
//    @Column(name="Cost")
//    private String cost;
//    @Column(name="EstimatedTime")
//    private String estimatedTime;
//    @Column(name="Note")
//    private String note;
//
//
//
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public int getJobId() {
//        return jobId;
//    }
//
//    public void setJobId(int jobId) {
//        this.jobId = jobId;
//    }
//
//    public String getVehicleRegNo() {
//        return vehicleRegNo;
//    }
//
//    public void setVehicleRegNo(String vehicleRegNo) {
//        this.vehicleRegNo = vehicleRegNo;
//    }
//
//
//
//    public String getStaffID() {
//        return staffID;
//    }
//
//    public void setStaffID(String staffID) {
//        this.staffID = staffID;
//    }
//
//    public Date getDateBooked() {
//        return dateBooked;
//    }
//
//    public void setDateBooked(Date dateBooked) {
//        this.dateBooked = dateBooked;
//    }
//
//    public String getJobType() {
//        return jobType;
//    }
//
//    public void setJobType(String jobType) {
//        this.jobType = jobType;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getActualTime() {
//        return actualTime;
//    }
//
//    public void setActualTime(String actualTime) {
//        this.actualTime = actualTime;
//    }
//
//    public String getCost() {
//        return cost;
//    }
//
//    public void setCost(String cost) {
//        this.cost = cost;
//    }
//
//    public String getEstimatedTime() {
//        return estimatedTime;
//    }
//
//    public void setEstimatedTime(String estimatedTime) {
//        this.estimatedTime = estimatedTime;
//    }
//
//    public String getNote() {
//        return note;
//    }
//
//    public void setNote(String note) {
//        this.note = note;
//    }
//
//    public List<BoatVariant> getBoatVariants() {
//        return boatVariants;
//    }
//
//    public void setBoatVariants(List<BoatVariant> boatVariants) {
//        this.boatVariants = boatVariants;
//    }
//
//    @Override
//    public String toString() {
//        return "Job{" +
//                "customer=" + customer +
//                ", jobId=" + jobId +
//                ", vehicleRegNo='" + vehicleRegNo + '\'' +
//                ", staffID='" + staffID + '\'' +
//                ", dateBooked=" + dateBooked +
//                ", jobType='" + jobType + '\'' +
//                ", status='" + status + '\'' +
//                ", actualTime='" + actualTime + '\'' +
//                ", cost='" + cost + '\'' +
//                ", estimatedTime='" + estimatedTime + '\'' +
//                ", note='" + note + '\'' +
//                ", boatVariants=" + boatVariants +
//                '}';
//    }
//}
