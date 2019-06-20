/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Boat.domain;

import java.util.List;
import javax.persistence.*;


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
    private String length;
    @Column(name="Width_cm")
    private String width;

    @Column(name="Weight_kg")
    private String weight;
    @Column(name="Depth_cm")
    private String depth;
    @Column(name="HeightOverWater_cm")
    private String heightOverWater;
    @Column(name="LengthInWater_cm")
    private String lengthWater;

    @Column(name="EngineMin_hp")
    private String engineMinHp;
    @Column(name="EngineMax_hp")
    private String engineMaxHp;

    @Column(name="PeopleOnBoard")
    private String peopleOnBoard;


    @Column(name="YearFrom")
    private String yearFrom;
     @Column(name="YearTo")
    private String yearTo;

       @Column(name="Description")
     private String description;




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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getHeightOverWater() {
        return heightOverWater;
    }

    public void setHeightOverWater(String heightOverWater) {
        this.heightOverWater = heightOverWater;
    }

    public String getLengthWater() {
        return lengthWater;
    }

    public void setLengthWater(String lengthWater) {
        this.lengthWater = lengthWater;
    }

    public String getEngineMinHp() {
        return engineMinHp;
    }

    public void setEngineMinHp(String engineMinHp) {
        this.engineMinHp = engineMinHp;
    }

    public String getEngineMaxHp() {
        return engineMaxHp;
    }

    public void setEngineMaxHp(String engineMaxHp) {
        this.engineMaxHp = engineMaxHp;
    }

    public String getPeopleOnBoard() {
        return peopleOnBoard;
    }

    public void setPeopleOnBoard(String peopleOnBoard) {
        this.peopleOnBoard = peopleOnBoard;
    }

    public String getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(String yearFrom) {
        this.yearFrom = yearFrom;
    }

    public String getYearTo() {
        return yearTo;
    }

    public void setYearTo(String yearTo) {
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
        return "Boat{" +
                "boatId=" + boatId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", mainCatagory='" + mainCatagory + '\'' +
                ", subCatagory='" + subCatagory + '\'' +
                ", length='" + length + '\'' +
                ", width='" + width + '\'' +
                ", weight='" + weight + '\'' +
                ", depth='" + depth + '\'' +
                ", heightOverWater='" + heightOverWater + '\'' +
                ", lengthWater='" + lengthWater + '\'' +
                ", engineMinHp='" + engineMinHp + '\'' +
                ", engineMaxHp='" + engineMaxHp + '\'' +
                ", peopleOnBoard='" + peopleOnBoard + '\'' +
                ", yearFrom='" + yearFrom + '\'' +
                ", yearTo='" + yearTo + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
