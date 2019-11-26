package restaurant.Entity;

public class Dish {

    // define a files
    private int dishId;

    private String name;

    private double price_buy_or_preparation;

    private double priceSell;

    // define constructors
    public Dish() {
    }

    public Dish(int dishId, String name, double price_buy_or_preparation, double priceSell) {
        this.dishId = dishId;
        this.name = name;
        this.price_buy_or_preparation = price_buy_or_preparation;
        this.priceSell = priceSell;
    }

    // define getters and setters
    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
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
                "productId=" + dishId +
                ", name='" + name + '\'' +
                ", price_buy_or_preparation=" + price_buy_or_preparation +
                ", priceSell=" + priceSell +
                '}';
    }
}
