/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Account.domain;

import javax.persistence.*;


/**
 *
 * @author douglaslandvik
 */

@Entity
public class Staff {


    @Id
    @Column(name="StaffID")
    private int staffID;


    @Column(name="Username")
    private String username;
    @Column(name="FirstName")
    private String firstName;
    @Column(name="LastName")
    private String lastName;
    @Column(name="Email")
    private String email;
    @Column(name="BuildingNo")
    private String buildingNo;
    @Column(name="HourlyRate")
    private String hourlyRate;

    @ManyToOne
    @JoinColumn(name="AddressPostCode",  insertable = false, updatable = false)
    private Address address;



}
