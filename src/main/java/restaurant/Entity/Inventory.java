package restaurant.Entity;


import java.math.BigDecimal;

public class Inventory {

    // define all files
    private int productId;

    private String name;

    private int quantity;

    private BigDecimal price;

    // define constructors
    public Inventory() {
    }

    public Inventory(int productId, String name, int quantity, BigDecimal price) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
