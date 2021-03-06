package uk.ac.city.douglas.varv.Boat.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class BoatStorage {

    @Id
    @Column(name="BoatStorageId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boatStorageId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="CustomerBoatID")
    private BoatVariant customerBoat;

    @Column(name="Status")
    private String status;
    @Column(name="PickUpDate")
    private String pickUpDate;
    @Column(name="DropOffDate")
    private String dropOffDate;

    private String comment;

    public BoatStorage() {
    }

    public int getBoatStorageId() {
        return boatStorageId;
    }

    public void setBoatStorageId(int boatStorageId) {
        this.boatStorageId = boatStorageId;
    }

    public BoatVariant getCustomerBoat() {
        return customerBoat;
    }

    public void setCustomerBoat(BoatVariant customerBoat) {
        this.customerBoat = customerBoat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "BoatStorage{" +
                "boatStorageId=" + boatStorageId +
                ", customerBoat=" + customerBoat +
                ", status='" + status + '\'' +
                ", pickUpDate='" + pickUpDate + '\'' +
                ", dropOffDate='" + dropOffDate + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
