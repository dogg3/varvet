package uk.ac.city.douglas.varv.Boat.dao;

import uk.ac.city.douglas.varv.Boat.domain.Boat;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;

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
    public List<BoatVariant> getAllCustomerBoats() {
        TypedQuery query = em.createQuery("SELECT b FROM BoatVariant AS b", BoatVariant.class);
        return query.getResultList();

    }
}
