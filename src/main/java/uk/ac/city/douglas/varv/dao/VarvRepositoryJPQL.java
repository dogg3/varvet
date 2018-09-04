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
import uk.ac.city.douglas.varv.domain.BoatVariantStorage;
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
        TypedQuery query = em.createQuery("SELECT b FROM Boat AS b",Boat.class);
        
        return query.getResultList();
        
    }

    @Override
    public void addEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void addboat(String brand, String model, float length, float width) {
    Boat boat = new Boat();
    boat.setBrand(brand);
    boat.setModel(model);
    boat.setLength(length);
    boat.setWidth(width);
    
    em.persist(boat);
    
    }

    @Override
    public void saveBoat(Boat boat) {
        em.persist(boat);
        System.out.println("done");
    }

    @Override
    public List<Customer> getAllCustomers(){ 
        TypedQuery query = em.createQuery("SELECT c FROM Customer AS c",Customer.class);
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
    public List<BoatVariantStorage> getAllBoatVariantStorages() {
        TypedQuery query = em.createQuery("SELECT bs FROM BoatVariantStorage AS bs",BoatVariantStorage.class);
        return query.getResultList();   
    }

    @Override
    public void addBoatVariant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
