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

        // to lower case name
        product.setName(product.getName().toLowerCase());

        // save product
        inventoryRepository.save(product);
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
            if (product.getQuantity() < quantity) {
                product.setQuantity(0);
                inventoryRepository.save(product);
            } else {
                product.removeQuantity(quantity);
                inventoryRepository.save(product);
            }

        });
    }

    @Override
    public void remove(int productId) {

        // delete product
        inventoryRepository.deleteById(productId);

    }
}
