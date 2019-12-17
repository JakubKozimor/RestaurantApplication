package restaurant.components;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateComponent {

    // define a file of date
    private LocalDate date = LocalDate.now();


    // define getter and setter
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // define toString
    @Override
    public String toString() {
        return "DateComponent{" +
                "date=" + date +
                '}';
    }


}
