package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.entity.Inventory;
import restaurant.dao.InventoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> getListOfProductsFromInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public void saveProduct(Inventory product) {
        product.setName(product.getName().toLowerCase());
        inventoryRepository.save(product);
    }


    @Override
    public Optional<Inventory> getSingleProduct(int idOfProduct) {
        return inventoryRepository.findById(idOfProduct);
    }

    @Override
    public void updateQuantity(int productId, Integer newQuantity) {
        Optional<Inventory> tempProduct = getSingleProduct(productId);
        tempProduct.ifPresent(product -> {
            product.setQuantity(newQuantity);
            inventoryRepository.save(product);
        });
    }

    @Override
    public void addQuantity(int productId, Integer quantity) {
        Optional<Inventory> temProduct = getSingleProduct(productId);
        temProduct.ifPresent(product -> {
            product.addQuantity(quantity);
            inventoryRepository.save(product);
        });
    }

    @Override
    public void removeQuantity(int productId, Integer quantity) {
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
        inventoryRepository.deleteById(productId);
    }
}
