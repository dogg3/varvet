/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.city.douglas.varv.Job.dao;

import java.util.HashMap;
import java.util.List;

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
public interface JobDAOInterface {

    



    //JOBS
    public List<Job> getAllJobs();
    public void addJob(Job job);
    public void eraseJobById(int id);
    public Job getJobById(int id);
    public void editJob(HashMap<String,String> jobData);

    
    
    //TASKDE-SCRIPTION
    public List<TaskDescription> getAllTaskDescriptions();
    public void addTaskDescription(TaskDescription taskDescription);
    public void eraseTaskDescriptionById(int id);
    public TaskDescription getTaskDescriptionById(int id);
    public void editTaskDescription(HashMap<String,String> taskDescriptionData);
    
    
    
    //Job-task
    public List<JobTask> getAllJobTasks();
    public void addJobTask(JobTask jobTask);
    public void eraseJobTaskById(int id);
    public JobTask getJobTaskById(int id);




    //TaskDescriptionPart
    public List<TaskDescriptionPart> getAllTaskDescriptionParts();
    public void addTaskDescriptionPart(TaskDescriptionPart taskDescriptionPart);
    public void eraseTaskDescriptionPartById(int id);
    public TaskDescriptionPart getTaskDescriptionPartById(int id);


    //JobPart
    public List<JobPart> getAllJobParts();
    public void addJobPart(JobPart jobPart);
    public void eraseJobPartById(int id);
    public JobPart getJobPartById(int id);
    





}
