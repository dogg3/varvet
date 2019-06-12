package uk.ac.city.douglas.varv.Boat.dao;

import uk.ac.city.douglas.varv.Boat.domain.Boat;
import uk.ac.city.douglas.varv.Boat.domain.BoatVariant;


import java.util.List;

public interface BoatDAOInterface {



    /*
     *boatDatabase
     */

    public List<Boat> getAllBoats();
    public List<BoatVariant> getAllCustomerBoats();
//    public Boat findBoatById(int id);
//    public void saveBoat(Boat boat);
//
//    public List<Boat> getAllBoatsByBrand(String brand);
//    public List<Boat> getAllBoatsByModel(String model);
//    public List<Boat> getAllBoatsById(int id);
//    public List<String> getAllBoatBrands();
//





}
