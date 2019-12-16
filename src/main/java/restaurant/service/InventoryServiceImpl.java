package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.Entity.Inventory;
import restaurant.data.InventoryData;
import restaurant.data.InventoryRepository;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> getListOfProductsFromInventory() {

        // return list of inventory
        return inventoryRepository.findAll();
    }

    @Override
    public void addToInventory(int theIdOfProduct, int quantity) {
//
//        // get product
//        Inventory tempInventory = theDataInventory.getSingleProduct(theIdOfProduct);
//
//        // get old quantity and add received quantity
//        int newQuantity = tempInventory.getQuantity() + quantity;
//
//        // set new quantity
//        theDataInventory.setQuantity(theIdOfProduct, newQuantity);
    }

    @Override
    public void removeFromInventory(int theIdOfProduct, int quantity) {
//
//        // get product
//        Inventory tempInventory = theDataInventory.getSingleProduct(theIdOfProduct);
//
//        // get old quantity and remove received quantity
//        int newQuantity = tempInventory.getQuantity() - quantity;
//
//        // set new quantity
//        theDataInventory.setQuantity(theIdOfProduct, newQuantity);
    }

    @Override
    public Inventory getSingleProduct(int idOfProduct) {
//
//        // return single product
//        return theDataInventory.getSingleProduct(idOfProduct);
        return null;
    }


}
