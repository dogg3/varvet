package uk.ac.city.douglas.varv.Account.dao;

import uk.ac.city.douglas.varv.Account.domain.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;


@Stateless
public class AccountDAO implements AccountDAOInterface {
    @PersistenceContext(unitName="ramsoPU")
    public EntityManager em;


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
        Customer customer = em.find(Customer.class, customerData.get("customerId"));
        em.getTransaction().begin();
            if(customerData.get("firstName")!=null){
                    customer.setFirstName(customerData.get("firstName"));
                }
            if(customerData.get("lastName")!=null){
                    customer.setLastName(customerData.get("lastName"));
            }
            if(customerData.get("tel")!=null){
                    customer.setTel(customerData.get("tel"));
            }
            if(customerData.get("email")!=null){
                    customer.setEmail(customerData.get("email"));
            }
            if(customerData.get("discountPlan")!=null){
                    customer.setDiscountPlan(customerData.get("discountPlan"));
            }
            if(customerData.get("identifier")!=null){
                    customer.setFirstName(customerData.get("identifier"));
            }
            em.getTransaction().commit();

    }




    @Override
    public Customer findCustomerById(int id) {
         return em.find(Customer.class, id);
    }

}
