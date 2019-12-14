package restaurant.data;

import restaurant.Entity.Date;
import restaurant.Entity.Dish;
import restaurant.Entity.Summary;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {

    public List<Integer> order1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1));
    public List<Integer> order2 = new ArrayList<>(Arrays.asList(1, 2, 3));
    public List<Integer> afterRemove = new ArrayList<>(Arrays.asList(1, 4, 5));

    private Dish dish1 = new Dish(1, "Pizza", BigDecimal.valueOf(24), BigDecimal.valueOf(30, 20));
    private Dish dish2 = new Dish(2, "Kebab", BigDecimal.valueOf(8), BigDecimal.valueOf(12));

    private Date theDate = new Date(1, LocalDate.now());

    private Summary sum1 = new Summary(1, 1, 0);
    private Summary sum2 = new Summary(1, 2, 0);

    private List<Summary> summaryOfDay = new ArrayList<>(Arrays.asList(sum1, sum2));
    private List<Date> allDays = new ArrayList<>(Arrays.asList(theDate));
    private List<Dish> allDishes = new ArrayList<>(Arrays.asList(dish1, dish2));

    public List<Summary> getSummaryOfDay(int dayId) {
        return summaryOfDay;
    }

    public List<Date> getListOfDates() {
        return allDays;
    }

    public List<Dish> getListOfDishes() {
        return allDishes;
    }

    public void addNewDay() {
        Date lastDay = this.allDays.get(allDays.size() - 1);
        int newId = lastDay.getDate_id() + 1;
        this.allDays.add(new Date(newId, LocalDate.now()));
    }

    public void setSummaryOfDayAfter(List<Summary> summaryOfDayAfter) {
        this.summaryOfDay = summaryOfDayAfter;
    }
}


