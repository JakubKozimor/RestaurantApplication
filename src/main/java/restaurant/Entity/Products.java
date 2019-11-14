package restaurant.Entity;

public class Products {

    // define a files
    private int productId;

    private String name;

    private double price_buy_or_preparation;

    private double priceSell;

    // define constructors
    public Products() {
    }

    public Products(int productId, String name, double price_buy_or_preparation, double priceSell) {
        this.productId = productId;
        this.name = name;
        this.price_buy_or_preparation = price_buy_or_preparation;
        this.priceSell = priceSell;
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

    public double getPrice_buy_or_preparation() {
        return price_buy_or_preparation;
    }

    public void setPrice_buy_or_preparation(double price_buy_or_preparation) {
        this.price_buy_or_preparation = price_buy_or_preparation;
    }

    public double getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(double priceSell) {
        this.priceSell = priceSell;
    }

    // define toString

    @Override
    public String toString() {
        return "Products{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price_buy_or_preparation=" + price_buy_or_preparation +
                ", priceSell=" + priceSell +
                '}';
    }
}
