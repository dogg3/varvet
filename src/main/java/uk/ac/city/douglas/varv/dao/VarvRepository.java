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
import uk.ac.city.douglas.varv.domain.BoatVariantEngine;

import uk.ac.city.douglas.varv.domain.Customer;
import uk.ac.city.douglas.varv.domain.Engine;
import uk.ac.city.douglas.varv.domain.Storage;

/**
 *
 * @author douglaslandvik
 */
public interface VarvRepository {
    
       /*
    *boatDatabase
    */
    public List<Boat> getAllBoats();
    public Boat findBoatById(int id);
    public void saveBoat(Boat boat);
    
    public List<Boat> getAllBoatsByBrand(String brand);
    public List<Boat> getAllBoatsByModel(String model);
    public List<Boat> getAllBoatsById(int id);
    public List<String> getAllBoatBrands();
  
  

    
   
    /*
    *customer
    */
    public List<Customer> getAllCustomers();
    public void saveCustomer(Customer customer);
    public void eraseCustomerById(int id);
    public void addEmployee();
    public Customer findCustomerById(int id);
 
   
    
       /*
    *storage
    */
    
    public List<Storage> getAllStorages();
    
       /*
    *BoatVariants - kundBåtar
    */
      public List<BoatVariant> getAllBoatVariants();
     public void saveBoatVariant(BoatVariant boatVariant);
     public void removeBoatVariant(BoatVariant boatVariant);
     public List<BoatVariant> findAllBoatVariantByCustomerId(int customerId);
     public BoatVariant findAllBoatVariantByCustomerIdAndBoatId(int customerId, int boatId);
    
    
      /*
    *engine
    */
    
    public List<Engine> getAllEngines();
    public List<Engine>findEnginesByBrand(String brand);
    public void addEngine(Engine engine);
    public void removeEngineById(int id);
    public Engine findEngineById(int id);
    
    
    
       /*
    *boatVariant engine
    */
    
    public void addBoatVariantEngine(BoatVariantEngine boatVariantEngine);
    public void removeBoatVariantEngineById(BoatVariantEngine boatVariantEngine);
    public List<BoatVariantEngine> findBoatVariantEngineById(int boatId, int customerId, int engineId);
    
   
    
    
       /*
    *BoatVariantStorages - kundbåtsVinterplats
    */
 
    
    
    
    
    
}
