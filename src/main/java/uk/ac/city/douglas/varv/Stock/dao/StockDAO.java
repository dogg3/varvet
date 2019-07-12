package uk.ac.city.douglas.varv.Stock.dao;

import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Finance.domain.Invoice;
import uk.ac.city.douglas.varv.Job.dao.JobDAOInterface;
import uk.ac.city.douglas.varv.Stock.domain.Inventory;
import uk.ac.city.douglas.varv.Stock.domain.Part;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;

@Stateless
public class StockDAO implements StockDAOInterface {

    @PersistenceContext(unitName = "ramsoPU")
    public EntityManager em;


    @Override
    public List<Part> getAllParts() {
        TypedQuery query = em.createQuery("SELECT p FROM Part AS p", Part.class);

        return query.getResultList();
    }

    @Override
    public Part getPartById(String id) {
        return em.find(Part.class,id);
    }



    //////INVENTORY

    @Override
    public List<Inventory> getAllInventoris() {
        TypedQuery query = em.createQuery("SELECT p FROM Inventory AS p", Inventory.class);

        return query.getResultList();
    }

    @Override
    public Inventory getInventoryById(int id) {
        return em.find(Inventory.class,id);
    }

    @Override
    public void saveInventory(Inventory inventory) {
        em.persist(inventory);
    }

    @Override
    public void eraseInventoryById(int id) {
        Inventory inventory = em.find(Inventory.class, id);
        em.remove(inventory);

    }

    @Override
    public void editInventory(HashMap<String, String> inventoryData) {
        Inventory inventory = em.find(Inventory.class, Integer.parseInt(inventoryData.get("inventoryId")));
        System.out.println(inventory);



//        if(customerData.get("firstName")!=null && !customerData.get("firstName").isEmpty()){
//            customer.setFirstName(customerData.get("firstName"));
//        }
//        if(customerData.get("lastName")!=null && !customerData.get("lastName").isEmpty()){
//            customer.setLastName(customerData.get("lastName"));
//        }
//        if(customerData.get("tel")!=null && !customerData.get("tel").isEmpty()){
//            customer.setTel(customerData.get("tel"));
//        }
//        if(customerData.get("email")!=null && !customerData.get("email").isEmpty()){
//            customer.setEmail(customerData.get("email"));
//        }
//        if(customerData.get("discountPlan")!= null && !customerData.get("discountPlan").isEmpty()){
//            customer.setDiscountPlan(customerData.get("discountPlan"));
//        }
//        if(customerData.get("identifier")!=null && !customerData.get("identifier").isEmpty()){
//            customer.setIdentifier(customerData.get("identifier"));
//        }
//
//        if(customerData.get("street")!=null && !customerData.get("street").isEmpty()){
//            customer.setStreet(customerData.get("street"));
//        }
//        if(customerData.get("town")!=null && !customerData.get("town").isEmpty()){
//            customer.setTown(customerData.get("town"));
//        }
//        if(customerData.get("postCode")!=null && !customerData.get("postCode").isEmpty()){
//            customer.setPostCode(customerData.get("postCode"));
//        }

        em.merge(inventory);
    }
}

