package uk.ac.city.douglas.varv.Account.dao;

import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Account.domain.Staff;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Stateless
public class AccountDAO implements AccountDAOInterface {
    @PersistenceContext(unitName="ramsoPU")
    public EntityManager em;


    //CUSTOMER CRUD

    @Override
    public List<Customer> getAllCustomers(){
        TypedQuery query = em.createQuery("SELECT c FROM Customer AS c",Customer.class);
        return query.getResultList();
    }

    @Override
    public void addCustomer(Customer customer) {
        em.persist(customer);

    }
    @Override
    public boolean eraseCustomerById(int id) {

        Customer customer = em.find(Customer.class, id);
        if(customer != null){
            em.remove(customer);
            return true;
        }
        return false;
    }

    @Override
    public void editCustomer(HashMap<String,String> customerData) {
        Customer customer = em.find(Customer.class, Integer.parseInt(customerData.get("customerId")));
        


            if(customerData.get("firstName")!=null && !customerData.get("firstName").isEmpty()){
                    customer.setFirstName(customerData.get("firstName"));
                }
            if(customerData.get("lastName")!=null && !customerData.get("lastName").isEmpty()){
                    customer.setLastName(customerData.get("lastName"));
            }
            if(customerData.get("tel")!=null && !customerData.get("tel").isEmpty()){
                    customer.setTel(customerData.get("tel"));
            }
            if(customerData.get("email")!=null && !customerData.get("email").isEmpty()){
                    customer.setEmail(customerData.get("email"));
            }
            if(customerData.get("discountPlan")!= null && !customerData.get("discountPlan").isEmpty()){
                    customer.setDiscountPlan(customerData.get("discountPlan"));
            }
            if(customerData.get("identifier")!=null && !customerData.get("identifier").isEmpty()){
                    customer.setIdentifier(customerData.get("identifier"));
            }

            if(customerData.get("street")!=null && !customerData.get("street").isEmpty()){
            customer.setStreet(customerData.get("street"));
            }
        if(customerData.get("town")!=null && !customerData.get("town").isEmpty()){
            customer.setTown(customerData.get("town"));
        }
        if(customerData.get("postCode")!=null && !customerData.get("postCode").isEmpty()){
            customer.setPostCode(customerData.get("postCode"));
        }
        
           em.merge(customer);

    }


    @Override
    public Customer findCustomerById(int id) {
         return em.find(Customer.class, id);
    }




    //CRUD STAFF


    @Override
    public List<Staff> getAllStaffs() {
        TypedQuery query = em.createQuery("SELECT s FROM Staff AS s",Staff.class);
        return query.getResultList();
    }

    @Override
    public void addStaff(Staff staff) {
        em.persist(staff);
    }

    @Override
    public void editStaff(HashMap<String, String> staffData) {
        Staff staff = em.find(Staff.class, Integer.parseInt(staffData.get("staffId")));



        if(staffData.get("firstName")!=null && !staffData.get("firstName").isEmpty()){
            staff.setFirstName(staffData.get("firstName"));
        }
        if(staffData.get("lastName")!=null && !staffData.get("lastName").isEmpty()){
            staff.setLastName(staffData.get("lastName"));
        }
        if(staffData.get("tel")!=null && !staffData.get("tel").isEmpty()){
            staff.setTel(staffData.get("tel"));
        }
        if(staffData.get("email")!=null && !staffData.get("email").isEmpty()){
            staff.setEmail(staffData.get("email"));
        }
        if(staffData.get("hourlyRate")!= null && !staffData.get("hourlyRate").isEmpty()){
            staff.setHourlyRate(staffData.get("hourlyRate"));
        }

        if(staffData.get("street")!=null && !staffData.get("street").isEmpty()){
            staff.setStreet(staffData.get("street"));
        }
        if(staffData.get("town")!=null && !staffData.get("town").isEmpty()){
            staff.setTown(staffData.get("town"));
        }
        if(staffData.get("postCode")!=null && !staffData.get("postCode").isEmpty()){
            staff.setPostCode(staffData.get("postCode"));
        }

        em.merge(staff);
    }

    @Override
    public void eraseStaffById(int id) {

        Staff staff = em.find(Staff.class, id);
        if(staff != null){
            em.remove(staff);
        }
    }

    @Override
    public Staff findStaffById(int id) {
        return em.find(Staff.class,id);
    }

}
