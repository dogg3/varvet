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

@Entity
public class Boat {
    
    
    @Id    
   @Column(name="BoatId")
    private int boatId;
    
    
     @Column(name="BrandName")
    private String brand;
    @Column(name="ModelName")
    private String model;
    @Column(name="MainCategory")
    private String mainCatagory;
    @Column(name="SubCategory")
    private String subCatagory;
    
    @Column(name="Length_cm")
    private int length;
    @Column(name="Width_cm")
    private int width;
    
    @Column(name="Weight_kg")
    private int weight;
    @Column(name="Depth_cm")
    private int depth;
    @Column(name="HeightOverWater_cm")
    private int heightOverWater;
    @Column(name="LengthInWater_cm")
    private int lengthWater;
    
    @Column(name="EngineMin_hp")
    private int engineMinHp;
    @Column(name="EngineMax_hp")
    private int engineMaxHp;
    
    @Column(name="PeopleOnBoard")
    private int peopleOnBoard;
     
     
    @Column(name="YearFrom")
    private float yearFrom;
     @Column(name="YearTo")
    private float yearTo;
     
       @Column(name="Description")
     private String description;
     
    
    @OneToMany(mappedBy="boat")
    List <BoatVariant> boatVariants;
    

    
    
    public Boat(){
    
    }

    public int getBoatId() {
        return boatId;
    }

    public void setBoatId(int boatId) {
        this.boatId = boatId;
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

    public String getMainCatagory() {
        return mainCatagory;
    }

    public void setMainCatagory(String mainCatagory) {
        this.mainCatagory = mainCatagory;
    }

    public String getSubCatagory() {
        return subCatagory;
    }

    public void setSubCatagory(String subCatagory) {
        this.subCatagory = subCatagory;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getHeightOverWater() {
        return heightOverWater;
    }

    public void setHeightOverWater(int heightOverWater) {
        this.heightOverWater = heightOverWater;
    }

    public int getLengthWater() {
        return lengthWater;
    }

    public void setLengthWater(int lengthWater) {
        this.lengthWater = lengthWater;
    }

    public int getEngineMinHp() {
        return engineMinHp;
    }

    public void setEngineMinHp(int engineMinHp) {
        this.engineMinHp = engineMinHp;
    }

    public int getEngineMaxHp() {
        return engineMaxHp;
    }

    public void setEngineMaxHp(int engineMaxHp) {
        this.engineMaxHp = engineMaxHp;
    }

    public int getPeopleOnBoard() {
        return peopleOnBoard;
    }

    public void setPeopleOnBoard(int peopleOnBoard) {
        this.peopleOnBoard = peopleOnBoard;
    }

    public float getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(float yearFrom) {
        this.yearFrom = yearFrom;
    }

    public float getYearTo() {
        return yearTo;
    }

    public void setYearTo(float yearTo) {
        this.yearTo = yearTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  

    
    @Override
    public String toString() {
        return "Boat{" + "boatId=" + boatId + ", brand=" + brand + ", model=" + model + ", mainCatagory=" + mainCatagory + ", subCatagory=" + subCatagory + ", length=" + length + ", width=" + width + ", weight=" + weight + ", depth=" + depth + ", heightOverWater=" + heightOverWater + ", lengthWater=" + lengthWater + ", engineMinHp=" + engineMinHp + ", engineMaxHp=" + engineMaxHp + ", peopleOnBoard=" + peopleOnBoard + ", yearFrom=" + yearFrom + ", yearTo=" + yearTo + '}';
    }

   




   

            
    
}
