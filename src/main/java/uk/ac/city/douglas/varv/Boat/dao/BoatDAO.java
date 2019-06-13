package uk.ac.city.douglas.varv.Boat.dao;

import uk.ac.city.douglas.varv.Boat.domain.Boat;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariantKey;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
public class BoatDAO implements BoatDAOInterface{

    @PersistenceContext(unitName="ramsoPU")
    private EntityManager em;

    @Override
    public List<Boat> getAllBoats() {
        TypedQuery query = em.createQuery("SELECT b FROM Boat AS b ORDER by b.brand ASC",Boat.class);
        return query.getResultList();
    }

    @Override
    public Boat getBoatById(int id) {

        return em.find(Boat.class, id);
    }

    @Override
    public List<BoatVariant> getAllCustomerBoats() {
        TypedQuery query = em.createQuery("SELECT b FROM BoatVariant AS b", BoatVariant.class);
        return query.getResultList();

    }

    @Override
    public void addBoatVariant(BoatVariant boatVariant) {
        em.persist(boatVariant);
    }

    @Override
    public boolean eraseBoatVariantById(int id) {
        BoatVariant boatVariant = em.find(BoatVariant.class, id);
        if(boatVariant != null){
            em.remove(boatVariant);
            return true;
        }
        return false;
    }


}
