package uk.ac.city.douglas.varv.Job;


import uk.ac.city.douglas.varv.Job.domain.JobTask;
import uk.ac.city.douglas.varv.Job.domain.TaskDescription;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface JobInterface {





	//Vehicles
//	public List<Boat> getAllVeichles() throws SQLException;
	public boolean eraseVehicleById(String regNo) throws SQLException;
	boolean updateVehicleById(HashMap<String, String> vehicleData) throws SQLException;
//	Boat getVehicleByRegNo(String regNo) throws SQLException;
	public double calculateDiscountAmount(double grossAmount, String discountType, String custID) throws SQLException;


	//Jobs
	ArrayList<String> getAllJobTypes() throws SQLException;
	public boolean addTask(HashMap<String, String> taskData) throws SQLException;
	public boolean addJobTask(HashMap<String, String> jobTaskData) throws SQLException;

	public boolean createJob(HashMap<String, String> jobData) throws SQLException;
	public boolean eraseJobByID(String jobID) throws SQLException;
	boolean updateJobByID(HashMap<String, String> jobData) throws SQLException;
//	public Job getJobByID(String jobID) throws SQLException;

//	List<Job> getAllJobs() throws SQLException;
//	List<JobTask> getAllJobTasksByJobID(String id) throws SQLException;
//	TaskDescription getTaskDescriptionByID(String taskDescriptionID) throws SQLException;
//
//
//    List<Job> getAllJobsStaffID(String id) throws SQLException;
//
//	boolean updateJobTaskStatus(HashMap<String, String> jobTaskData) throws SQLException;
//
//    List<Job> getJobByCustID(int customerID) throws SQLException;
}