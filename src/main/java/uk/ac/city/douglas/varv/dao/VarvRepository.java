/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.dao;

import static java.util.Collections.list;
import java.util.List;
import uk.ac.city.douglas.varv.domain.Boat;
import uk.ac.city.douglas.varv.domain.BoatVariant;
import uk.ac.city.douglas.varv.domain.BoatVariantStorage;
import uk.ac.city.douglas.varv.domain.Customer;
import uk.ac.city.douglas.varv.domain.Engine;
import uk.ac.city.douglas.varv.domain.Storage;

/**
 *
 * @author douglaslandvik
 */
public interface VarvRepository {
    
       /*
    *boat
    */
        public List<Boat> getAllBoats();
    public void addboat(String brand, String model, float length, float width);
    public void saveBoat(Boat boat);
    
   
    /*
    *customer
    */
    public List<Customer> getAllCustomers();
    public void saveCustomer(Customer customer);
    public void eraseCustomerById(int id);
    public void addEmployee();
   
    
       /*
    *storage
    */
    
    public List<Storage> getAllStorages();
    
       /*
    *BoatVariants - kundBåtar
    */
      public List<BoatVariant> getAllBoatVariants();
    
    
    
      /*
    *engine
    */
    
    public List<Engine> getAllEngines();
    
       /*
    *engine
    */
    
    
       /*
    *BoatVariantStorages - kundbåtsVinterplats
    */
    public List<BoatVariantStorage> getAllBoatVariantStorages();
     public void addBoatVariant();
    
    
    
    
}
