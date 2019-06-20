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
import uk.ac.city.douglas.varv.Job.domain.JobTask;
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






    /////JOB-TASKS
    @Override
    public List<JobTask> getAllJobTasks() {
        TypedQuery query = em.createQuery("SELECT jt FROM JobTask AS jt",JobTask.class);
        return query.getResultList();
    }

    @Override
    public void addJobTask(JobTask jobTask) {
        em.persist(jobTask);

    }

    @Override
    public void eraseJobTaskById(int id) {
        JobTask jobTask = em.find(JobTask.class,id);
        em.remove(jobTask);

    }

    @Override
    public JobTask getJobTaskById(int id) {
        return em.find(JobTask.class,id);
    }


    
}
