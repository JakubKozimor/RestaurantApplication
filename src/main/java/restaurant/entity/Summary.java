package restaurant.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "summary")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "summary_id")
    private int summaryId;

    @NotNull
    @Column(name = "date", columnDefinition = "date")
    private LocalDate date;

    @NotNull
    @OneToOne(targetEntity = Dish.class)
    @JoinColumn(name = "dish", columnDefinition = "int")
    private Dish dish;

    @NotNull
    @Column(name = "quantity", columnDefinition = "int default '0' ")
    private int quantity;

    public Summary() {
    }

    public Summary(LocalDate date, Dish dish) {
        this.date = date;
        this.dish = dish;
    }

    public Summary(LocalDate date, Dish dish, int quantity) {
        this.date = date;
        this.dish = dish;
        this.quantity = quantity;
    }

    public int getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(int summary_id) {
        this.summaryId = summary_id;
    }

    public LocalDate getdate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Dish getdish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
