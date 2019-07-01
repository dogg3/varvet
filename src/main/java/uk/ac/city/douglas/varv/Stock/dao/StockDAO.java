package uk.ac.city.douglas.varv.Stock.dao;

import uk.ac.city.douglas.varv.Account.domain.Customer;
import uk.ac.city.douglas.varv.Job.dao.JobDAOInterface;
import uk.ac.city.douglas.varv.Stock.domain.Inventory;
import uk.ac.city.douglas.varv.Stock.domain.Part;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
}

