package restaurant.Entity;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    // define all files
    private int productId;

    private String name;

    private int quantity;

    private double price;

    List<Inventory> listOfProducts = new ArrayList<>();


    // define constructors
    public Inventory() {
        Inventory product1 = new Inventory(1, "mleko", 3, 2.50);
        Inventory product2 = new Inventory(2, "kukurydza", 6, 3.10);
        listOfProducts.add(product1);
        listOfProducts.add(product2);
    }

    public Inventory(int productId, String name, int quantity, double price) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // define getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Inventory> getListOfProducts() {


        return listOfProducts;
    }

    public void setListOfProducts(List<Inventory> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }

    // define toString
    @Override
    public String toString() {
        return "Inventory{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
