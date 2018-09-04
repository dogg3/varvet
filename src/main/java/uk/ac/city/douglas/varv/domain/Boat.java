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
import uk.ac.city.douglas.varv.domain.BoatKey;

/**
 *
 * @author douglaslandvik
 */
@IdClass(BoatKey.class)
@Entity
public class Boat {
    
    @Id
    private String brand;
    @Id
    private String model;
    private float length;
    private float width;
    private float weight;
    @Column(name="gasolineTank")
    private float tank;
    
    @OneToMany(mappedBy="boat")
    List <BoatVariant> boatVariants;
    

    
    
    public Boat(){
    
    }

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

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

   

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Boat{" + "brand=" + brand + ", model=" + model + ", length=" + length + ", width=" + width + ", weight=" + weight + ", tank=" + tank + '}';
    }

   


   

            
    
}
