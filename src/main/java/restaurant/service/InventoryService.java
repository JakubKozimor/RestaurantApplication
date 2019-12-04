package restaurant.service;

import restaurant.Entity.Inventory;

import java.util.List;

public interface InventoryService {

    List<Inventory> getListOfProductsFromInventory();

    void removeFromInventory(int theIdOfProduct, int quantity);

    void addToInventory(int theIdOfProduct, int quantity);

    Inventory getSingleProduct(int idOfProduct);

}
