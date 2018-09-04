/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;

/**
 *
 * @author douglaslandvik
 */
@IdClass(EngineKey.class)
@Entity
public class Engine {
    @Id
    private String brand;
    @Id
    private String model;
    private int year;
    @Column(name="horse_power")
    private double horsePower;
    
     @OneToMany(mappedBy="engine")
    List <BoatVariant> boatVariants;
    

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Engine{" + "brand=" + brand + ", model=" + model + ", year=" + year + ", horsePower=" + horsePower + '}';
    }
    
    
    
    
}
