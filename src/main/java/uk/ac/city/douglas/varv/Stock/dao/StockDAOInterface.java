package uk.ac.city.douglas.varv.Stock.dao;


import uk.ac.city.douglas.varv.Stock.domain.Inventory;
import uk.ac.city.douglas.varv.Stock.domain.Part;

import java.util.HashMap;
import java.util.List;

public interface StockDAOInterface {


    /*
     *boatDatabase
     */

    public List<Part> getAllParts();
    public Part getPartById(String id);

    //INVENTORY
    public List<Inventory> getAllInventoris();
    public Inventory getInventoryById(int id);
    public void saveInventory(Inventory inventory);
    public void eraseInventoryById(int id);
    public void editInventory(HashMap<String, String> inventoryData);


}
