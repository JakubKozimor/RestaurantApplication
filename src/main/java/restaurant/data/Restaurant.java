package restaurant.data;
import restaurant.Entity.Date;
import restaurant.Entity.Dish;
import restaurant.Entity.Summary;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {

    public List<Integer> order1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 1));
    public List<Integer> order2 = new ArrayList<>(Arrays.asList(1, 2, 3));
    public List<Integer> afterRemove = new ArrayList<>(Arrays.asList(1, 4, 5));

    private Dish dish1 = new Dish(1, "Pizza", 24, 30);
    private Dish dish2 = new Dish(2, "Kebab", 8, 12);

    private Date theDate = new Date(1, LocalDate.now());

    private Summary sum1 = new Summary(1, 1, 0);
    private Summary sum2 = new Summary(1, 2, 0);

    private List<Summary> summaryOfDay = new ArrayList<>(Arrays.asList(sum1, sum2));
    private List<Date> allDays = new ArrayList<>(Arrays.asList(theDate));
    private List<Dish> allDishes = new ArrayList<>(Arrays.asList(dish1,dish2));

    public List<Summary> getSummaryOfDay(int dayId) {
        return summaryOfDay;
    }

    public List<Date> getListOfDates() {
        return allDays;
    }
    public List<Dish> getListOfDishes() {
        return allDishes;
    }


    public void setSummaryOfDayAfter(List<Summary> summaryOfDayAfter) {
        this.summaryOfDay = summaryOfDayAfter;
    }
}
