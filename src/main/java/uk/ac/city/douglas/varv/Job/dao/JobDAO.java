/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Job.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Job.domain.Job;
import uk.ac.city.douglas.varv.Job.domain.TaskDescription;
//import uk.ac.city.douglas.varv.Boat.domain.Boat;
//import uk.ac.city.douglas.varv.Job.domain.BoatVariant;
//import uk.ac.city.douglas.varv.Job.domain.BoatVariantEngine;
//
//import uk.ac.city.douglas.varv.Job.domain.Engine;
//import uk.ac.city.douglas.varv.Job.domain.Storage;

/**
 *
 * @author douglaslandvik
 */
@Stateless
public class JobDAO implements JobDAOInterface {

    @PersistenceContext(unitName="ramsoPU")
    public EntityManager em;




    //JOBS

    @Override
    public List<Job> getAllJobs() {
        TypedQuery query = em.createQuery("SELECT j FROM Job AS j",Job.class);
        return query.getResultList();
    }

    @Override
    public void addJob(Job job) {
         em.persist(job);
    }

    @Override
    public void eraseJobById(int id) {
    Job job = em.find(Job.class, id);
    em.remove(job);
    }

    @Override
    public Job getJobById(int id) {
            return em.find(Job.class,id);
    }






    //TASK DESCRIPTIONS
    @Override
    public List<TaskDescription> getAllTaskDescriptions() {
        TypedQuery query = em.createQuery("SELECT t FROM TaskDescription AS t",TaskDescription.class);
        return query.getResultList();
    }

    @Override
    public void addTaskDescription(TaskDescription taskDescription) {
        em.persist(taskDescription);
    }

    @Override
    public void eraseTaskDescriptionById(int id) {
        TaskDescription taskDescription = em.find(TaskDescription.class, id);
        em.remove(taskDescription);

    }

    @Override
    public TaskDescription getTaskDescriptionById(int id) {
        return em.find(TaskDescription.class,id);
    }



////
////    @Override
////    public void addEmployee() {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
////    }
////
////    @Override
////    public void saveBoat(Boat boat) {
////        em.persist(boat);
////
////    }
//
//


//    @Override
//    public List<Storage> getAllStorages() {
//      TypedQuery query = em.createQuery("SELECT s FROM Storage AS s",Storage.class);
//        return query.getResultList();
//
//    }
//
//    @Override
//    public List<Engine> getAllEngines() {
//         TypedQuery query = em.createQuery("SELECT e FROM Engine AS e",Engine.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public List<BoatVariant> getAllBoatVariants() {
//  TypedQuery query = em.createQuery("SELECT b FROM BoatVariant AS b",BoatVariant.class);
//        return query.getResultList();
//
//    }
//
//
//
//    @Override
//    public void saveBoatVariant(BoatVariant boatVariant) {
//    em.persist(boatVariant);
//
//    }
//
//    @Override
//    public List<Boat> getAllBoatsByBrand(String brand) {
//        TypedQuery query = em.createQuery("SELECT b FROM Boat AS b WHERE b.brand LIKE :brand ORDER BY b.brand", Boat.class);
//        query.setParameter("brand", brand+"%");
//
//        return query.getResultList();
//
//
//    }
//
//    @Override
//    public List<Boat> getAllBoatsByModel(String model) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Boat> getAllBoatsById(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<String> getAllBoatBrands() {
//           TypedQuery query = em.createQuery("SELECT DISTINCT b.brand  FROM Boat AS b", String.class);
//        return query.getResultList();
//
//    }
//
//    @Override
//    public Boat findBoatById(int id) {
//        return em.find(Boat.class, id);
//    }
//

//    @Override
//    public List<Engine> findEnginesByBrand(String brand) {
//         TypedQuery query = em.createQuery("SELECT e FROM Engine AS e WHERE e.brand LIKE :brand ORDER BY e.brand", Engine.class);
//        query.setParameter("brand", brand+"%");
//
//        return query.getResultList();
//
//    }
//
//    @Override
//    public void addEngine(Engine engine) {
//            em.persist(engine);
//
//    }
//
//
//    @Override
//    public Engine findEngineById(int id) {
//          return em.find(Engine.class, id);
//
//    }
//
//
//
//
//
//    @Override
//    public void removeEngineById(int id) {
//    Engine engine = em.find(Engine.class, id);
//        em.remove(engine);
//    }
//
//    @Override
//    public List<BoatVariant> findAllBoatVariantByCustomerId(int customerId) {
//    TypedQuery query = em.createQuery("SELECT bv FROM BoatVariant AS bv WHERE bv.customerId = :customerId ", BoatVariant.class);
//        query.setParameter("customerId", customerId);
//
//        return query.getResultList();
//
//    }
//
//
//    //nya jävlar
//
//    @Override
//    public void addBoatVariantEngine(BoatVariantEngine boatVariantEngine) {
//        em.persist(boatVariantEngine);
//
//    }
//
//    @Override
//    public void removeBoatVariantEngineById(BoatVariantEngine boatVariantEngine)  {
//       em.remove(boatVariantEngine);
//    }
//
//    @Override
//    public List<BoatVariantEngine> findBoatVariantEngineById(int boatId, int customerId, int engineId) {
//        TypedQuery query = em.createQuery("SELECT bve FROM BoatVariantEngine AS bve WHERE bve.customerId = :customerId AND bve.boatId = :boatId AND bve.engineId = :engineId ", BoatVariantEngine.class);
//        query.setParameter("customerId", customerId);
//        query.setParameter("boatId", boatId);
//        query.setParameter("engineId", engineId);
//
//        return query.getResultList();
//
//    }
//
//    @Override
//    public BoatVariant findAllBoatVariantByCustomerIdAndBoatId(int customerId, int boatId) {
//    TypedQuery query = em.createQuery("SELECT bv FROM BoatVariant AS bv WHERE bve.customerId = :customerId AND bve.boatId = :boatId", BoatVariant.class);
//        query.setParameter("customerId", customerId);
//        query.setParameter("boatId", boatId);
//
//
//        return (BoatVariant) query.getSingleResult();
//    }
//
//    @Override
//    public void removeBoatVariant(BoatVariant boatVariant) {
//        em.remove(boatVariant);
//    }

    
}
