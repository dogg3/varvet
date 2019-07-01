/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Stock.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import uk.ac.city.douglas.varv.Job.domain.Job;

import java.util.List;
import javax.persistence.*;


/**
 *
 * @author douglaslandvik
 */


@Entity
public class Part {


    @Id
    @Column(name="ArtNr")
    private String artNr;


    @Column(name="Priskod")
    private String prisKod;
    @Column(name="Benamning")
    private String benamning;

    @Column(name="Beskrivning")
    private String description;
    @Column(name="Varugrupp")
    private String varuGrupp;

    @Column(name="PrisBrutenForp")
    private String prisBrutenForp;

    @Column(name="Antal")
    private String antal;

    @Column(name="PrisNormalForp")
    private String prisNormalForp;


    @Column(name="PrisStorForp")
    private String prisStorForp;

    @Column(name="KatalogPrisExMoms")
    private String katalogPrisExMoms;

    @Column(name="KatalogPrisInkMoms")
    private String getKatalogPrisInkMoms;

    @Column(name="EANkod")
    private String eanKod;

    @Column(name="Momskod")
    private String momsKod;

    @Column(name="Reseller")
    private String reseller;

    @OneToMany(mappedBy = "part" , fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<Inventory> inventories;


    public String getArtNr() {
        return artNr;
    }

    public void setArtNr(String artNr) {
        this.artNr = artNr;
    }

    public String getPrisKod() {
        return prisKod;
    }

    public void setPrisKod(String prisKod) {
        this.prisKod = prisKod;
    }

    public String getBenamning() {
        return benamning;
    }

    public void setBenamning(String benamning) {
        this.benamning = benamning;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVaruGrupp() {
        return varuGrupp;
    }

    public void setVaruGrupp(String varuGrupp) {
        this.varuGrupp = varuGrupp;
    }

    public String getPrisBrutenForp() {
        return prisBrutenForp;
    }

    public void setPrisBrutenForp(String prisBrutenForp) {
        this.prisBrutenForp = prisBrutenForp;
    }

    public String getAntal() {
        return antal;
    }

    public void setAntal(String antal) {
        this.antal = antal;
    }

    public String getPrisNormalForp() {
        return prisNormalForp;
    }

    public void setPrisNormalForp(String prisNormalForp) {
        this.prisNormalForp = prisNormalForp;
    }

    public String getPrisStorForp() {
        return prisStorForp;
    }

    public void setPrisStorForp(String prisStorForp) {
        this.prisStorForp = prisStorForp;
    }

    public String getKatalogPrisExMoms() {
        return katalogPrisExMoms;
    }

    public void setKatalogPrisExMoms(String katalogPrisExMoms) {
        this.katalogPrisExMoms = katalogPrisExMoms;
    }

    public String getGetKatalogPrisInkMoms() {
        return getKatalogPrisInkMoms;
    }

    public void setGetKatalogPrisInkMoms(String getKatalogPrisInkMoms) {
        this.getKatalogPrisInkMoms = getKatalogPrisInkMoms;
    }

    public String getEanKod() {
        return eanKod;
    }

    public void setEanKod(String eanKod) {
        this.eanKod = eanKod;
    }

    public String getMomsKod() {
        return momsKod;
    }

    public void setMomsKod(String momsKod) {
        this.momsKod = momsKod;
    }


    public String getReseller() {
        return reseller;
    }

    public void setReseller(String reseller) {
        this.reseller = reseller;
    }


    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    @Override
    public String toString() {
        return "Part{" +
                "artNr='" + artNr + '\'' +
                ", prisKod='" + prisKod + '\'' +
                ", benamning='" + benamning + '\'' +
                ", description='" + description + '\'' +
                ", varuGrupp='" + varuGrupp + '\'' +
                ", prisBrutenForp='" + prisBrutenForp + '\'' +
                ", antal='" + antal + '\'' +
                ", prisNormalForp='" + prisNormalForp + '\'' +
                ", prisStorForp='" + prisStorForp + '\'' +
                ", katalogPrisExMoms='" + katalogPrisExMoms + '\'' +
                ", getKatalogPrisInkMoms='" + getKatalogPrisInkMoms + '\'' +
                ", eanKod='" + eanKod + '\'' +
                ", momsKod='" + momsKod + '\'' +
                ", reseller='" + reseller + '\'' +
                '}';
    }
}
