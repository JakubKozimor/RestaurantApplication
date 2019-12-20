package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.Entity.Inventory;
import restaurant.data.InventoryRepository;

import java.util.List;
import java.util.Optional;

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
    public void saveProduct(Inventory product) {
        inventoryRepository.save(product);
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
    public Optional<Inventory> getSingleProduct(int idOfProduct) {

        // return single product
        return inventoryRepository.findById(idOfProduct);
    }

    @Override
    public void updateQuantity(int productId, Integer newQuantity) {

        // set new quantity and update in database
        Optional<Inventory> tempProduct = getSingleProduct(productId);
        tempProduct.ifPresent(product -> {
            product.setQuantity(newQuantity);
            inventoryRepository.save(product);
        });
    }

    @Override
    public void addQuantity(int productId, Integer quantity) {

        // add quantity
        Optional<Inventory> temProduct = getSingleProduct(productId);
        temProduct.ifPresent(product -> {
            product.addQuantity(quantity);
            inventoryRepository.save(product);
        });

    }

    @Override
    public void removeQuantity(int productId, Integer quantity) {

        // remove quantity
        Optional<Inventory> tempProduct = getSingleProduct(productId);
        tempProduct.ifPresent(product ->{
            product.removeQuantity(quantity);
            inventoryRepository.save(product);
        });
    }
}
