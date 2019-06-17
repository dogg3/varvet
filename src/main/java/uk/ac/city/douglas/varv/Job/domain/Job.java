//*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package uk.ac.city.douglas.varv.Job.domain;

import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Account.domain.Staff;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;

import java.sql.Date;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author douglaslandvik
 */

@Entity
public class Job {


    @Id
    @Column(name="JobID")
    private int jobId;
    @Column(name="dateBooked")
    private String dateBooked;
    @Column(name="Status")
    private String status;
    @Column(name="ActualTime")
    private String actualTime;
    @Column(name="Cost")
    private String cost;
    @Column(name="JobType")
    private String jobType;
    @Column(name="EstimatedTime")
    private String estimatedTime;
    @Column(name="Note")
    private String note;


    @OneToOne
    @JoinColumn(name = "StaffID", insertable = false, updatable = false)
    private Staff staff;

    @OneToOne
    @JoinColumn(name = "CustomerBoatId", insertable = false, updatable = false)
    private BoatVariant boatVariant;

    public Job(){

    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(String dateBooked) {
        this.dateBooked = dateBooked;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActualTime() {
        return actualTime;
    }

    public void setActualTime(String actualTime) {
        this.actualTime = actualTime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public BoatVariant getBoatVariant() {
        return boatVariant;
    }

    public void setBoatVariant(BoatVariant boatVariant) {
        this.boatVariant = boatVariant;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", dateBooked=" + dateBooked +
                ", status='" + status + '\'' +
                ", actualTime='" + actualTime + '\'' +
                ", cost='" + cost + '\'' +
                ", jobType='" + jobType + '\'' +
                ", estimatedTime='" + estimatedTime + '\'' +
                ", note='" + note + '\'' +
                ", staff=" + staff +
                ", boatVariant=" + boatVariant +
                '}';
    }
}
