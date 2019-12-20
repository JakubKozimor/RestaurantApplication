package restaurant.service;

import restaurant.Entity.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {

    List<Inventory> getListOfProductsFromInventory();

    Optional<Inventory> getSingleProduct(int idOfProduct);

    void saveProduct(Inventory product);

    void updateQuantity(int productId, Integer newQuantity);

    void addQuantity(int productId, Integer newQuantity);

    void removeQuantity(int productId, Integer newQuantity);

    void remove(int productId);
}
