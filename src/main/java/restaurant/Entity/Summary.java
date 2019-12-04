package restaurant.Entity;

public class Summary {

    // define files
    private int date_id;

    private int dish_id;

    private int quantity;

    // define constructors
    public Summary() {
    }

    public Summary(int date_id, int dish_id, int quantity) {
        this.date_id = date_id;
        this.dish_id = dish_id;
        this.quantity = quantity;
    }

    // define getters and setters
    public int getDate_id() {
        return date_id;
    }

    public void setDate_id(int date_id) {
        this.date_id = date_id;
    }

    public int getDish_id() {
        return dish_id;
    }

    public void setDish_id(int dish_id) {
        this.dish_id = dish_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // define toString
    @Override
    public String toString() {
        return "Summary{" +
                "date_id=" + date_id +
                ", dish_id=" + dish_id +
                ", quantity=" + quantity +
                '}';
    }
}
