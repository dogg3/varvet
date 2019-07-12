package uk.ac.city.douglas.varv.Boat.dao;

import uk.ac.city.douglas.varv.Boat.domain.*;


import java.util.HashMap;
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
    public void editBoatVariant(HashMap<String,String> boatVariantData);

    
    ///ENGINE
    public List<Engine> getAllEngines();
    public void addEngine(Engine engine);
    public boolean eraseEngineById(int id);
    public Engine findEngineById(int id);
    public void editEngine(HashMap<String,String> engineData);
    
    
    
    ///BOAT-STORAGE
    public List<BoatStorage> getAllBoatStorages();
    public void addBoatStorage(BoatStorage boatStorage);
    public boolean eraseBoatStorageById(int id);
    public BoatStorage findBoatStorageById(int id);
    public void editBoatStorage(HashMap<String,String> boatStorageData);




    ///BOAT-VARIANT-ENGINE
    public List<BoatVariantEngine> getAllBoatVariantEngines();
    public void addBoatVariantEngine(BoatVariantEngine boatVariantEngine);
    public boolean eraseBoatVariantEngineById(int id);
    public BoatVariantEngine findBoatVariantEngineById(int id);









}
