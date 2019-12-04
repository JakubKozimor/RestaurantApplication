package restaurant.Entity;

import java.time.LocalDate;

public class Date {

    // define files
    private int date_id;

    private LocalDate date;

    // define constructors
    public Date() {
    }

    public Date(int date_id, LocalDate date) {
        this.date_id = date_id;
        this.date = date;
    }

    // define getters and setters
    public int getDate_id() {
        return date_id;
    }

    public void setDate_id(int date_id) {
        this.date_id = date_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // define toString
    @Override
    public String toString() {
        return "Date{" +
                "date_id=" + date_id +
                ", date=" + date +
                '}';
    }
}
