package restaurant.Entity;

import java.math.BigDecimal;

public class Dish {

    // define a files
    private int dishId;

    private String name;

    private BigDecimal price_buy_or_preparation;

    private BigDecimal priceSell;

    // define constructors
    public Dish() {
    }

    public Dish(int dishId, String name, BigDecimal price_buy_or_preparation, BigDecimal priceSell) {
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

    public BigDecimal getPrice_buy_or_preparation() {
        return price_buy_or_preparation;
    }

    public void setPrice_buy_or_preparation(BigDecimal price_buy_or_preparation) {
        this.price_buy_or_preparation = price_buy_or_preparation;
    }

    public BigDecimal getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(BigDecimal priceSell) {
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
