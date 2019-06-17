/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Job.dao;

import java.util.List;

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
public interface JobDAOInterface {

    



    //JOBS
    public List<Job> getAllJobs();
    public void addJob(Job job);
    public void eraseJobById(int id);
    public Job getJobById(int id);

    
    
    //TASKDE-SCRIPTION
    public List<TaskDescription> getAllTaskDescriptions();
    public void addTaskDescription(TaskDescription taskDescription);
    public void eraseTaskDescriptionById(int id);
    public TaskDescription getTaskDescriptionById(int id);
    
    
    
    

    /*
    *customer
    */
//    public void saveCustomer(Customer customer);
//    public void eraseCustomerById(int id);
//    public void addEmployee();
//    public Customer findCustomerById(int id);
//
//
//
//       /*
//    *storage
//    */
//
//    public List<Storage> getAllStorages();
//
//       /*
//    *BoatVariants - kundBåtar
//    */
//      public List<BoatVariant> getAllBoatVariants();
//     public void saveBoatVariant(BoatVariant boatVariant);
//     public void removeBoatVariant(BoatVariant boatVariant);
//     public List<BoatVariant> findAllBoatVariantByCustomerId(int customerId);
//     public BoatVariant findAllBoatVariantByCustomerIdAndBoatId(int customerId, int boatId);
//
//
//      /*
//    *engine
//    */
//
//    public List<Engine> getAllEngines();
//    public List<Engine>findEnginesByBrand(String brand);
//    public void addEngine(Engine engine);
//    public void removeEngineById(int id);
//    public Engine findEngineById(int id);
//
//
//
//       /*
//    *boatVariant engine
//    */
//
//    public void addBoatVariantEngine(BoatVariantEngine boatVariantEngine);
//    public void removeBoatVariantEngineById(BoatVariantEngine boatVariantEngine);
//    public List<BoatVariantEngine> findBoatVariantEngineById(int boatId, int customerId, int engineId);
//
//
//
//
//       /*
//    *BoatVariantStorages - kundbåtsVinterplats
//    */
//
//
    
    
    
    
}
