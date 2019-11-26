package restaurant.service;

import restaurant.Entity.Inventory;

import java.util.List;
import java.util.Map;

public interface InventoryService {

    List<Inventory> getListOfProducts();
    void removeFromInventory(int theIdOfProduct, int quantity);
    void addToInventory(int theIdOfProduct, int quantity);

}
