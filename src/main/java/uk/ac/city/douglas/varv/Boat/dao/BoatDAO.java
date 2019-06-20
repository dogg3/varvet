package uk.ac.city.douglas.varv.Boat.dao;

import uk.ac.city.douglas.varv.Boat.domain.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Stateless
public class BoatDAO implements BoatDAOInterface{

    @PersistenceContext(unitName="ramsoPU")
    private EntityManager em;



    /////BOATS///////////////
    @Override
    public List<Boat> getAllBoats() {
        TypedQuery query = em.createQuery("SELECT b FROM Boat AS b ORDER by b.brand ASC",Boat.class);
        return query.getResultList();
    }

    @Override
    public Boat getBoatById(int id) {

        return em.find(Boat.class, id);
    }




    //////////BOATVARIANT/////////////////////
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

    @Override
    public BoatVariant findBoatVariantById(int id) {
        return em.find(BoatVariant.class,id);
    }








    //////////////////////////ENGINE//////////////////

    @Override
    public List<Engine> getAllEngines() {
        TypedQuery query = em.createQuery("SELECT b FROM Engine AS b", Engine.class);
        return query.getResultList();
    }

    @Override
    public void addEngine(Engine engine) {
        em.persist(engine);

    }

    @Override
    public boolean eraseEngineById(int id) {
      Engine engine = em.find(Engine.class, id);
      em.remove(engine);
      return true;
    }

    @Override
    public Engine findEngineById(int id) {
    return em.find(Engine.class, id);

    }






    
    ////BOAT-STORAGE/////////////////////
    @Override
    public List<BoatStorage> getAllBoatStorages() {
        TypedQuery query = em.createQuery("SELECT b FROM BoatStorage AS b", BoatStorage.class);
        return query.getResultList();
    }

    @Override
    public void addBoatStorage(BoatStorage boatStorage) {
        em.persist(boatStorage);

    }

    @Override
    public boolean eraseBoatStorageById(int id) {
        BoatStorage boatStorage=   em.find(BoatStorage.class,id);
        em.remove(boatStorage);
        return true;
    }

    @Override
    public BoatStorage findBoatStorageById(int id) {
        return em.find(BoatStorage.class,id);
    }








    /////////////////////////BOATVARIANT-ENGINE/////////////////////////////


    @Override
    public List<BoatVariantEngine> getAllBoatVariantEngines() {
        TypedQuery query = em.createQuery("SELECT b FROM BoatVariantEngine AS b", BoatVariantEngine.class);
        return query.getResultList();
    }

    @Override
    public void addBoatVariantEngine(BoatVariantEngine boatVariantEngine) {
        em.persist(boatVariantEngine);

    }

    @Override
    public boolean eraseBoatVariantEngineById(int id) {
        BoatVariantEngine boatVariantEngine = em.find(BoatVariantEngine.class, id);
        return true;
    }

    @Override
    public BoatVariantEngine findBoatVariantEngineById(int id) {
            return em.find(BoatVariantEngine.class, id);

    }


}
