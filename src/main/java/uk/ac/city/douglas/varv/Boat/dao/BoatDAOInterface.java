package uk.ac.city.douglas.varv.Boat.dao;

import uk.ac.city.douglas.varv.Boat.domain.Boat;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariantKey;


import java.util.List;

public interface BoatDAOInterface {



    /*
     *boatDatabase
     */

    public List<Boat> getAllBoats();
    public Boat getBoatById(int id);

    //BoatVariants aka customerBoats
    public List<BoatVariant> getAllCustomerBoats();
    public void addBoatVariant(BoatVariant boatVariant);
    public boolean eraseBoatVariantById(int id);
    public BoatVariant findBoatVariantById(int id);

//    public Boat findBoatById(int id);
//    public void saveBoat(Boat boat);
//
//    public List<Boat> getAllBoatsByBrand(String brand);
//    public List<Boat> getAllBoatsByModel(String model);
//    public List<Boat> getAllBoatsById(int id);
//    public List<String> getAllBoatBrands();






}
