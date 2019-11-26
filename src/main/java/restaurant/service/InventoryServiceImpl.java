package restaurant.service;

import org.springframework.stereotype.Service;
import restaurant.Entity.Inventory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InventoryServiceImpl implements InventoryService {

    Inventory inventory = new Inventory();
    List<Inventory> listOfProducts = inventory.getListOfProducts();

    @Override
    public List<Inventory> getListOfProducts() {

        // return list of inventory
        return listOfProducts;
    }

    @Override
    public void removeFromInventory(int theIdOfProduct, int quantity) {

        Inventory tempInventory = listOfProducts.get(theIdOfProduct-1);
        int newQuantity = tempInventory.getQuantity()-quantity;
        tempInventory.setQuantity(newQuantity);
    }

    @Override
    public void addToInventory(int theIdOfProduct, int quantity) {

        Inventory tempInventory = listOfProducts.get(theIdOfProduct-1);
        int newQuantity = tempInventory.getQuantity()+quantity;
        tempInventory.setQuantity(newQuantity);
    }
}
