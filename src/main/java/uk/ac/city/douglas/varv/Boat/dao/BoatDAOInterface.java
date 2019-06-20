package uk.ac.city.douglas.varv.Boat.dao;

import uk.ac.city.douglas.varv.Boat.domain.Boat;
import uk.ac.city.douglas.varv.Boat.domain.BoatStorage;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;
import uk.ac.city.douglas.varv.Job.domain.Engine;


import java.util.List;

public interface BoatDAOInterface {



    /*
     *boatDatabase
     */

    ///BOATS
    public List<Boat> getAllBoats();
    public Boat getBoatById(int id);

    //BoatVariants aka customerBoats
    public List<BoatVariant> getAllCustomerBoats();
    public void addBoatVariant(BoatVariant boatVariant);
    public boolean eraseBoatVariantById(int id);
    public BoatVariant findBoatVariantById(int id);

    ///ENGINE
    public List<Engine> getAllEngines();
    public void addEngine(Engine engine);
    public boolean eraseEngineById(int id);
    public Engine findEngineById(int id);
    
    
    
    ///BOAT-STORAGE

    public List<BoatStorage> getAllBoatStorages();
    public void addBoatStorage(BoatStorage boatStorage);
    public boolean eraseBoatStorageById(int id);
    public BoatStorage findBoatStorageById(int id);
    






}
