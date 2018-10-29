
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author douglaslandvik
 */
@IdClass(BoatVariantKey.class)
@Entity
@Table(name = "boat_variant_engine")
public class BoatVariantEngine {

    @Id
    private int customerId;
    @Id
    private int boatId;
    @Id
    private int engineId;
    
    

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "boatId", referencedColumnName="boatId", insertable = false, updatable = false),
            @JoinColumn(name = "engineId",referencedColumnName = "engineId", insertable = false, updatable = false)
            
    
    })
    private BoatVariant boatVariant;

    @ManyToOne
    @JoinColumn(name = "engine", insertable = false, updatable = false)
    private Engine engine;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBoatId() {
        return boatId;
    }

    public void setBoatId(int boatId) {
        this.boatId = boatId;
    }

    public int getEngineId() {
        return engineId;
    }

    public void setEngineId(int engineId) {
        this.engineId = engineId;
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
        return "BoatVariantEngine{" + "customerId=" + customerId + ", boatId=" + boatId + ", engineId=" + engineId + ", boatVariant=" + boatVariant + ", engine=" + engine + '}';
    }

}
