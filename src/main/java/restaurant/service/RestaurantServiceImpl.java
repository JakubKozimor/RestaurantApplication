package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.Entity.Dish;
import restaurant.components.DateComponent;
import restaurant.components.TablesComponent;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    TablesComponent theTablesComponent;

    @Autowired
    DateComponent theDateComponent;

    @Autowired
    SummaryService theSummaryService;

    @Override
    public void addOrder(int theNumberOfTable, List<Dish> theListOfOrders) {

        // get table
        List<Dish> theTable = theTablesComponent.getMyRestaurant(theNumberOfTable);

        // add order to list of table
        theTable.addAll(theListOfOrders);

        // add ordered list of products to table
        theTablesComponent.setMyRestaurant(theNumberOfTable, theTable);
    }

    @Override
    public void removeElementFromOrder(int theNumberOfTable, List<Dish> theListToRemove) {

        // get table
        List<Dish> theTable = theTablesComponent.getMyRestaurant().get(theNumberOfTable);

        // get all tables
        Map<Integer, List<Dish>> myRestaurant = theTablesComponent.getMyRestaurant();

        // filter list of order
        List<Dish> afterRemove = theTable.stream()
                .filter(dish -> {
                    if (theListToRemove.contains(dish)) {
                        theListToRemove.remove(dish);
                        return false;
                    }
                    return true;
                })
                .collect(Collectors.toList());

        // set table after remove order
        myRestaurant.put(theNumberOfTable, afterRemove);


    }


    @Override
    public void removeOrderWithoutAcceptPayment(int theNumberOfTable) {

        // get all tables
        Map<Integer, List<Dish>> myRestaurant = theTablesComponent.getMyRestaurant();

        // create empty integer list
        List<Dish> emptyTable = new ArrayList<>();

        // set table as empty
        myRestaurant.put(theNumberOfTable, emptyTable);

    }

    @Override
    public BigDecimal acceptPaymentAndCleanOrder(int theNumberOfTable) {

        // update summary of day
        theSummaryService.updateSummary(theNumberOfTable);

        // set initial sum at 0
        BigDecimal sum = BigDecimal.valueOf(0);

        // get table
        List<Dish> theTable = theTablesComponent.getMyRestaurant().get(theNumberOfTable);

//        // get list of all days
//        List<Date> listOfDays = theRestaurant.getListOfDates();
//
//        // find today
//        List<Date> theDays = listOfDays.stream()
//                .filter(date -> date.getDate().equals(LocalDate.now()))
//                .collect(Collectors.toList());
//
//        // set today to variable
//        Date theDay = theDays.get(0);
//
//        // get summary of today
//        List<Summary> listOfSummary = theRestaurant.getSummaryOfDay(theDay.getDate_id());

        // get all dishes
//        List<Dish> listOfDishes = theRestaurant.getListOfDishes();

        // calculate sum and and quantity to summary
        for (Dish tempDish : theTable) {
            sum = sum.add(tempDish.getPriceSell());
//            for (Summary tempSummary : listOfSummary) {
//                if (tempTable == tempSummary.getDish_id()) {
//                    int tempQuantity = tempSummary.getQuantity() + 1;
//                    tempSummary.setQuantity(tempQuantity);
//                }
//            }
        }
//        theRestaurant.setSummaryOfDayAfter(listOfSummary);

        // clear order of table
        ArrayList<Dish> emptyList = new ArrayList<>();
        theTablesComponent.setMyRestaurant(theNumberOfTable, emptyList);

        // return sum
        return sum;
    }



}
