package uk.ac.city.douglas.varv.Stock.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Inventory {

    @Id
    @Column(name="artNr",updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int artNr;


    @Column(name="Amount")
    private String amount;
    @Column(name="ThresHold")
    private String thresHold;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="resellerArtNr")
    private Part part;


    public Inventory() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getThresHold() {
        return thresHold;
    }

    public void setThresHold(String thresHold) {
        this.thresHold = thresHold;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public int getArtNr() {
        return artNr;
    }

    public void setArtNr(int artNr) {
        this.artNr = artNr;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "artNr=" + artNr +
                ", amount='" + amount + '\'' +
                ", thresHold='" + thresHold + '\'' +
                ", part=" + part +
                '}';
    }
}
