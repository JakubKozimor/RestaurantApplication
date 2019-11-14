package restaurant.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import restaurant.service.MenuService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class DaySummaryComponent {

    // define file a summary of the day
    private Map<LocalDate, HashMap<Integer, Integer>> day = new HashMap<>();

    // define constructors
    public DaySummaryComponent() {

    }

    public DaySummaryComponent(Map<LocalDate, HashMap<Integer, Integer>> day) {
        this.day = day;
    }

    // define getters and setters
    public Map<LocalDate, HashMap<Integer, Integer>> getDay() {
        return day;
    }

    public void setDay(Map<LocalDate, HashMap<Integer, Integer>> day) {
        this.day = day;
    }

    // define toString

    @Override
    public String toString() {
        return "DaySummaryComponent{" +
                "day=" + day +
                '}';

    }
}
