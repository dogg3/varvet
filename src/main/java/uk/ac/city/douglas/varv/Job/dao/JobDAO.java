/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Job.dao;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Job.domain.*;
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

    @Override
    public void editJob(HashMap<String, String> jobData) {
        Job job = em.find(Job.class, jobData.get("jobId"));
        //TODO implement editJob
    em.merge(job);
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

    @Override
    public void editTaskDescription(HashMap<String, String> taskDescriptionData) {
        TaskDescription taskDescription = em.find(TaskDescription.class,taskDescriptionData.get("taskDescriptionId"));

        //TODO implement editTaskDescription

        em.merge(taskDescription);

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




    ///TASKDESCRIPTIONPARTS

    @Override
    public List<TaskDescriptionPart> getAllTaskDescriptionParts() {
        TypedQuery query = em.createQuery("SELECT jt FROM TaskDescriptionPart AS jt",TaskDescriptionPart.class);
        return query.getResultList();
    }

    @Override
    public void addTaskDescriptionPart(TaskDescriptionPart taskDescriptionPart) {
        em.persist(taskDescriptionPart);

    }

    @Override
    public void eraseTaskDescriptionPartById(int id) {
        TaskDescriptionPart taskDescriptionPart = em.find(TaskDescriptionPart.class, id);
        em.remove(taskDescriptionPart);
    }

    @Override
    public TaskDescriptionPart getTaskDescriptionPartById(int id) {

        return em.find(TaskDescriptionPart.class,id);

    }



    ///////JOBPARTS

    @Override
    public List<JobPart> getAllJobParts() {
        TypedQuery query = em.createQuery("SELECT jt FROM JobPart AS jt",JobPart.class);
        return query.getResultList();
    }

    @Override
    public void addJobPart(JobPart jobPart) {
        em.persist(jobPart);

    }

    @Override
    public void eraseJobPartById(int id) {
        JobPart jobPart = em.find(JobPart.class,id);
        em.remove(jobPart);

    }

    @Override
    public JobPart getJobPartById(int id) {

        return em.find(JobPart.class, id);
    }


}
