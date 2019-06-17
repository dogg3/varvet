package uk.ac.city.douglas.varv.Account;



import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Account.domain.Staff;
//import uk.ac.city.douglas.varv.Job.domain.Job;
import uk.ac.city.douglas.varv.Job.domain.TaskDescription;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface AccountControllerInterface {

    //Vheicle
    public boolean addVehicle(HashMap<String, String> vehicleData) throws SQLException;

    //Genereate invoice
    boolean generateInvoice(int customerID) throws SQLException;
    //Customer
    public boolean addCustomer(HashMap<String, String> customerData) throws SQLException;
    public Customer getCustomerById(String id) throws SQLException;
    public List<Customer> getAllCustomers() throws SQLException;
    public boolean removeCustomerById(int id) throws SQLException;
    public boolean updateCustomerById(HashMap<String, String> customerData) throws SQLException;







    //Staff
    public List<Staff> getAllStaffByRole(String role) throws SQLException;
    public ArrayList<Staff> getAllStaff()throws SQLException;
    public boolean addStaff(HashMap<String, String> staffData) throws SQLException;
    public Staff getStaff(String staffID) throws SQLException;
    public boolean removeStaffUsername(String username) throws SQLException;
    public boolean doesUserNameExist(String username) throws SQLException;
    public boolean addRole(String role, String staffID) throws SQLException;
    public String getIdByUsername(String username) throws SQLException;
    public boolean removeAccount(String staffID) throws SQLException;
    public boolean removeRoleByStaffId(String staffID) throws SQLException;
    public boolean setHourlyRate(String mechanicUsername, String hourlyRate) throws SQLException;
    public boolean updateStaff(HashMap<String, String> staffData) throws SQLException;



    //JOB

//    public Job getJob(int jobId);


    public void createJob(String customerName, Time estimatedTime, Time actualTime);


    public void reminder(String content, int customerID);


    public boolean makePayment(double amount);


    public void generateInvoice(float totalCost, float VAT, String content, Date date);


    public void sendAlert();

    List<TaskDescription> getAllTaskDescriptions() throws SQLException;

}
