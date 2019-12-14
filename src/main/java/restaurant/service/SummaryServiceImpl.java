package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.Entity.Date;
import restaurant.Entity.Dish;
import restaurant.Entity.Summary;
import restaurant.components.DateComponent;
import restaurant.components.TablesComponent;
import restaurant.data.Restaurant;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    DateComponent theDateComponent;

    @Autowired
    TablesComponent theTablesComponent;

    Restaurant theRestaurant = new Restaurant();

    @Override
    public void updateSummary(int theNumberOfTable) {


        // get table
        List<Dish> theTable = theTablesComponent.getMyRestaurant().get(theNumberOfTable);

        List<Date> listOfDates = theRestaurant.getListOfDates();

        // get list of all days
        List<Date> listOfDays = theRestaurant.getListOfDates();

        // find today
        List<Date> theListOfDays = listOfDays.stream()
                .filter(date -> date.getDate().equals(LocalDate.now()))
                .collect(Collectors.toList());

        // set today to variable
        Date theDay;
        if (theListOfDays.isEmpty()) {
            theRestaurant.addNewDay();
            List<Date> listOfDatesWithNewDay = theRestaurant.getListOfDates();
            theDay = listOfDatesWithNewDay.get(0);
        } else {
            theDay = theListOfDays.get(0);
        }

        // get summary of day
        List<Summary> listOfSummary = theRestaurant.getSummaryOfDay(theDay.getDate_id());

        System.out.println(theDay);


        // todo update summary


    }
}
