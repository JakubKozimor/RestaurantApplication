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
import java.util.*;
import java.util.stream.Collectors;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    TablesComponent theTablesComponent;

    @Autowired
    DateComponent theDateComponent;

    private Restaurant theRestaurant = new Restaurant();

    @Override
    public void addOrder(int theNumberOfTable, List<Integer> theListOfOrders) {

        // get table
        List<Integer> theTable = theTablesComponent.getMyRestaurant(theNumberOfTable);

        // add order to list of table
        theTable.addAll(theListOfOrders);

        // add ordered list of products to table
        theTablesComponent.setMyRestaurant(theNumberOfTable, theTable);
    }

    @Override
    public void removeElementFromOrder(int theNumberOfTable, List<Integer> theListToRemove) {

        // get table
        List<Integer> theTable = theTablesComponent.getMyRestaurant().get(theNumberOfTable);

        // get all tables
        Map<Integer, List<Integer>> myRestaurant = theTablesComponent.getMyRestaurant();

        for (int i = 0; i < theTable.size(); i++) {
            for (int j = 0; j < theListToRemove.size(); j++) {
                if (theTable.get(i) == theListToRemove.get(j)) {
                    theTable.remove(theTable.get(i));
                    theListToRemove.remove(theListToRemove.get(j));
                }
            }
        }

        // set table after remove part of order
        myRestaurant.put(theNumberOfTable, theTable);


    }

    @Override
    public void removeOrderWithoutAcceptPayment(int theNumberOfTable) {

        // get all tables
        Map<Integer, List<Integer>> myRestaurant = theTablesComponent.getMyRestaurant();

        // create empty integer list
        List<Integer> emptyTable = new ArrayList<>();

        // set table as empty
        myRestaurant.put(theNumberOfTable, emptyTable);

    }

    @Override
    public double acceptPaymentAndCleanOrder(int theNumberOfTable) {

        double sum = 0;

        // get table
        List<Integer> theTable = theTablesComponent.getMyRestaurant().get(theNumberOfTable);

        // get list of all days
        List<Date> listOfDays = theRestaurant.getListOfDates();

        // find today
        List<Date> theDays = listOfDays.stream()
                .filter(date -> date.getDate().equals(LocalDate.now()))
                .collect(Collectors.toList());

        // set today to variable
        Date theDay = theDays.get(0);

        // get summary of today
        List<Summary> listOfSummary = theRestaurant.getSummaryOfDay(theDay.getDate_id());

        // get all dishes
        List<Dish> listOfDishes = theRestaurant.getListOfDishes();

        // calculate sum and and quantity to summary
        for (Integer tempTable : theTable) {
            for (Dish tempDish : listOfDishes) {
                if (tempDish.getDishId() == tempTable) {
                    sum += tempDish.getPriceSell();
                }
            }
            for (Summary tempSummary : listOfSummary) {
                if (tempTable == tempSummary.getDish_id()) {
                    int tempQuantity = tempSummary.getQuantity() + 1;
                    tempSummary.setQuantity(tempQuantity);
                }
            }
        }
        theRestaurant.setSummaryOfDayAfter(listOfSummary);

        // clear order of table
        ArrayList<Integer> emptyList = new ArrayList<>();
        theTablesComponent.setMyRestaurant(theNumberOfTable, emptyList);

        // return sum
        return sum;
    }


}
