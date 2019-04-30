package uk.ac.city.douglas.varv.Account.dao;

import uk.ac.city.douglas.varv.Account.domain.Customer;

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
            System.out.println(customer);
           for(Map.Entry mapElemnt: customerData.entrySet()){
            System.out.println(
                    "Customer data hash map" + mapElemnt.getKey() +
                            " value " +mapElemnt.getValue()
            );
           }


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


            System.out.println("customer precis innan merger "  + customer);
           em.merge(customer);

    }




    @Override
    public Customer findCustomerById(int id) {
         return em.find(Customer.class, id);
    }

}
