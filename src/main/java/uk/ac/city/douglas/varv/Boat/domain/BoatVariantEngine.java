/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Boat.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;
import uk.ac.city.douglas.varv.Boat.domain.Engine;

import javax.persistence.*;

/**
 *
 * @author douglaslandvik
 */
@Entity
@Table(name = "CustomerBoatEngine")
public class BoatVariantEngine {

    @Id
    @Column(name="CustomerBoatEngineId",updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CustomerBoatEngineId;

    @ManyToOne
    @JoinColumn(name="CustomerBoatId")
    @JsonBackReference
    private BoatVariant boatVariant;

    @ManyToOne
    @JoinColumn(name="engineId")
    @JsonBackReference
    private Engine engine;


    public BoatVariantEngine() {
    }


    public int getCustomerBoatEngineId() {
        return CustomerBoatEngineId;
    }

    public void setCustomerBoatEngineId(int customerBoatEngineId) {
        CustomerBoatEngineId = customerBoatEngineId;
    }

    public BoatVariant getBoatVariant() {
        return boatVariant;
    }

    public void setBoatVariant(BoatVariant boatVariant) {
        this.boatVariant = boatVariant;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }


    @Override
    public String toString() {
        return "BoatVariantEngine{" +
                "CustomerBoatEngineId=" + CustomerBoatEngineId +
                ", boatVariant=" + boatVariant +
                ", engine=" + engine +
                '}';
    }
}
