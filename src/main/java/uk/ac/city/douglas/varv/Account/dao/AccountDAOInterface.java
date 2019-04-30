package uk.ac.city.douglas.varv.Account.dao;

import uk.ac.city.douglas.varv.Account.domain.Customer;
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

//
//    /*Staff**/
//    public boolean addStaff();
//    public boolean editEditStaff();
//    public boolean remove();
//    public boolean getCustomerById();




}
