/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
@Stateless
public class VarvRepositoryJPQL implements VarvRepository {

    @PersistenceContext
    private EntityManager em;
    
    

    @Override
    public List<Boat> getAllBoats() {
        TypedQuery query = em.createQuery("SELECT b FROM Boat AS b ORDER by b.brand ASC",Boat.class);
        
        return query.getResultList();
        
    }

    @Override
    public void addEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveBoat(Boat boat) {
        em.persist(boat);
     
    }

    @Override
    public List<Customer> getAllCustomers(){ 
        TypedQuery query = em.createQuery("SELECT c FROM Customer AS c ORDER by c.firstName ASC",Customer.class);
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        em.persist(customer);
    }

    @Override
    public void eraseCustomerById(int id) {
        Customer customer = em.find(Customer.class, id);
        em.remove(customer);
    }

    @Override
    public List<Storage> getAllStorages() {
      TypedQuery query = em.createQuery("SELECT s FROM Storage AS s",Storage.class);
        return query.getResultList();

    }

    @Override
    public List<Engine> getAllEngines() {
         TypedQuery query = em.createQuery("SELECT e FROM Engine AS e",Engine.class);
        return query.getResultList();
    }

    @Override
    public List<BoatVariant> getAllBoatVariants() {
  TypedQuery query = em.createQuery("SELECT b FROM BoatVariant AS b",BoatVariant.class);
        return query.getResultList();    
    
    }

 

    @Override
    public void saveBoatVariant(BoatVariant boatVariant) {
    em.persist(boatVariant);    
    
    }

    @Override
    public List<Boat> getAllBoatsByBrand(String brand) {
        TypedQuery query = em.createQuery("SELECT b FROM Boat AS b WHERE b.brand LIKE :brand ORDER BY b.brand", Boat.class);
        query.setParameter("brand", brand+"%");
     
        return query.getResultList();
        
        
    }

    @Override
    public List<Boat> getAllBoatsByModel(String model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Boat> getAllBoatsById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getAllBoatBrands() {
           TypedQuery query = em.createQuery("SELECT DISTINCT b.brand  FROM Boat AS b", String.class);
        return query.getResultList();   
        
    }

    @Override
    public Boat findBoatById(int id) {
        return em.find(Boat.class, id);
    }

    @Override
    public Customer findCustomerById(int id) {
         return em.find(Customer.class, id);
    }

    @Override
    public List<Engine> findEnginesByBrand(String brand) {
         TypedQuery query = em.createQuery("SELECT e FROM Engine AS e WHERE e.brand LIKE :brand ORDER BY e.brand", Engine.class);
        query.setParameter("brand", brand+"%");
     
        return query.getResultList();
       
    }

    @Override
    public void addEngine(Engine engine) {
            em.persist(engine);
        
    }

 
    @Override
    public Engine findEngineById(int id) {
          return em.find(Engine.class, id);
       
    }



     

    @Override
    public void removeEngineById(int id) {
    Engine engine = em.find(Engine.class, id);
        em.remove(engine);
    }

    @Override
    public List<BoatVariant> findAllBoatVariantByCustomerId(int customerId) {
    TypedQuery query = em.createQuery("SELECT bv FROM BoatVariant AS bv WHERE bv.customerId = :customerId ", BoatVariant.class);
        query.setParameter("customerId", customerId);
     
        return query.getResultList();
    
    }
    
    
    //nya jävlar

    @Override
    public void addBoatVariantEngine(BoatVariantEngine boatVariantEngine) {
        em.persist(boatVariantEngine);
       
    }

    @Override
    public void removeBoatVariantEngineById(BoatVariantEngine boatVariantEngine)  {
       em.remove(boatVariantEngine);
    }

    @Override
    public List<BoatVariantEngine> findBoatVariantEngineById(int boatId, int customerId, int engineId) {
        TypedQuery query = em.createQuery("SELECT bve FROM BoatVariantEngine AS bve WHERE bve.customerId = :customerId AND bve.boatId = :boatId AND bve.engineId = :engineId ", BoatVariantEngine.class);
        query.setParameter("customerId", customerId);
        query.setParameter("boatId", boatId);
        query.setParameter("engineId", engineId);
     
        return query.getResultList();
    
    }

    @Override
    public BoatVariant findAllBoatVariantByCustomerIdAndBoatId(int customerId, int boatId) {
    TypedQuery query = em.createQuery("SELECT bv FROM BoatVariant AS bv WHERE bve.customerId = :customerId AND bve.boatId = :boatId", BoatVariant.class);
        query.setParameter("customerId", customerId);
        query.setParameter("boatId", boatId);
     
     
        return (BoatVariant) query.getSingleResult();
    }

    @Override
    public void removeBoatVariant(BoatVariant boatVariant) {
        em.remove(boatVariant);
    }

    
}
