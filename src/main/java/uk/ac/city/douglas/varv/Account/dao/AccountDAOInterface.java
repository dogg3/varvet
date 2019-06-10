package uk.ac.city.douglas.varv.Account.dao;

import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Account.domain.Staff;
import uk.ac.city.douglas.varv.Boat.domain.Boat;

import java.util.HashMap;
import java.util.List;

public interface AccountDAOInterface {

    /*CUSTOMER**/
    public List<Customer> getAllCustomers();
    public void addCustomer(Customer customer);
    public void editCustomer(HashMap<String,String> customerData);
    public boolean eraseCustomerById(int id);
    public Customer findCustomerById(int id);


    /*Staff**/
    public List<Staff> getAllStaffs();
    public void addStaff(Staff staff);
    public void editStaff(HashMap<String,String> staffData);
    public void eraseStaffById(int id);
    public Staff findStaffById(int id);




}
