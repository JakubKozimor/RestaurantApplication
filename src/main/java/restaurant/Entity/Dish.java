package restaurant.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Entity
@Table(name = "Dish")
public class Dish {

    // define a files
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private int dishId;

    @NotNull
    @Column(name = "dish_name", columnDefinition = "varchar(255)")
    private String name;

    @NotNull
    @Column(name = "dish_price_buy_or_preparation",columnDefinition = "decimal(10,2)")
    private BigDecimal price_buy_or_preparation;

    @NotNull
    @Column(name = "dish_price_sell", columnDefinition = "decimal(10,2)")
    private BigDecimal priceSell;

    @Column(name = "description", columnDefinition = "varchar(255)")
    private String description;

    @NotNull
    @Column(name = "category", columnDefinition = "varchar(255)")
    private String category;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
