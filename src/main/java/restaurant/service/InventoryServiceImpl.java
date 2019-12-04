package restaurant.service;

import org.springframework.stereotype.Service;
import restaurant.Entity.Inventory;
import restaurant.data.InventoryData;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private InventoryData theDataInventory = new InventoryData();

    @Override
    public List<Inventory> getListOfProductsFromInventory() {

        // return list of inventory
        return theDataInventory.getListOfProductsFromInventory();
    }

    @Override
    public void addToInventory(int theIdOfProduct, int quantity) {

        // get product
        Inventory tempInventory = theDataInventory.getSingleProduct(theIdOfProduct);

        // get old quantity and add received quantity
        int newQuantity = tempInventory.getQuantity() + quantity;

        // set new quantity
        theDataInventory.setQuantity(theIdOfProduct, newQuantity);
    }

    @Override
    public void removeFromInventory(int theIdOfProduct, int quantity) {

        // get product
        Inventory tempInventory = theDataInventory.getSingleProduct(theIdOfProduct);

        // get old quantity and remove received quantity
        int newQuantity = tempInventory.getQuantity() - quantity;

        // set new quantity
        theDataInventory.setQuantity(theIdOfProduct, newQuantity);
    }

    @Override
    public Inventory getSingleProduct(int idOfProduct) {

        // return single product
        return theDataInventory.getSingleProduct(idOfProduct);
    }


}
