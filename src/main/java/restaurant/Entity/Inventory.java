package restaurant.Entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @NotNull(message = "Nazwa nie może byś pusta")
    @NotBlank(message = "Nazwa nie może byś pusta")
    @Pattern(regexp = "[a-zA-Z]+", message = "Nazwa nie może zawierać znaków specjalnych")
    @Column(name = "product_name", columnDefinition = "varchar(255)")
    private String name;

    @NotNull
    @Min(value = 0,message = "Wartość musi być większa od 0")
    @Column(name = "product_quantity", columnDefinition = "int default '0'")
    private int quantity;

    @NotNull(message = "Pole nie może być puste")
    @Digits(integer = 10, fraction = 2, message = "Wartość przed kropką nie może mieć więcej niż 10 znaków i więcej niż 2 po kropce")
    @Column(name = "product_price", columnDefinition = "decimal(10,2)")
    private BigDecimal price;

    public Inventory() {
    }

    public Inventory(int productId, String name, int quantity, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

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

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
    }

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
