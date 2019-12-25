package restaurant.Entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;


@Entity
@Table(name = "Dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private int dishId;

    @NotNull(message = "Nazwa nie może byś pusta")
    @NotBlank(message = "Nazwa nie może byś pusta")
    @Column(name = "dish_name", columnDefinition = "varchar(255)")
    private String name;

    @NotNull(message = "Pole nie może być puste")
    @Digits(integer = 10, fraction = 2, message = "Wartość przed kropką nie może mieć więcej niż 10 znaków i więcej niż 2 po kropce")
    @Column(name = "dish_price_buy_or_preparation",columnDefinition = "decimal(10,2)")
    private BigDecimal price_buy_or_preparation;

    @NotNull(message = "Pole nie może być puste")
    @Digits(integer = 10, fraction = 2, message = "Wartość przed kropką nie może mieć więcej niż 10 znaków i więcej niż 2 po kropce")
    @Column(name = "dish_price_sell", columnDefinition = "decimal(10,2)")
    private BigDecimal priceSell;

    @NotNull(message = "Nazwa nie może byś pusta")
    @NotBlank(message = "Nazwa nie może byś pusta")
    @Column(name = "description", columnDefinition = "varchar(255)")
    private String description;

    @NotNull
    @Column(name = "category", columnDefinition = "varchar(255)")
    private String category;

    public Dish() {

    }

    public Dish(int dishId, String name, BigDecimal price_buy_or_preparation, BigDecimal priceSell) {
        this.dishId = dishId;
        this.name = name;
        this.price_buy_or_preparation = price_buy_or_preparation;
        this.priceSell = priceSell;

    }

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

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", name='" + name + '\'' +
                ", price_buy_or_preparation=" + price_buy_or_preparation +
                ", priceSell=" + priceSell +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
