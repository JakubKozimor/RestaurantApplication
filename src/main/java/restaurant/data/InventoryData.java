package restaurant.data;

import restaurant.Entity.Inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryData {

    private Inventory product1 = new Inventory(1, "mleko", 3, 2.50);
    private Inventory product2 = new Inventory(2, "kukurydza", 6, 3.10);

    private List<Inventory> list = new ArrayList<>(Arrays.asList(product1, product2));

    public List<Inventory> getListOfProductsFromInventory() {
        return list;
    }

    public void setQuantity(int theIdOfProduct, int newQuantity) {
        Inventory tempProduct = list.get(theIdOfProduct - 1);
        tempProduct.setQuantity(newQuantity);
    }

    public Inventory getSingleProduct(int idOfProduct) {
        return list.get(idOfProduct - 1);
    }


}
