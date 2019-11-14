package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.components.DateComponent;
import restaurant.components.DaySummaryComponent;
import restaurant.components.TablesComponent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    TablesComponent theTablesComponent;

    @Autowired
    MenuService theMenuService;

    @Autowired
    DateComponent theDateComponent;

    DaySummaryComponent theDaySummaryComponent = new DaySummaryComponent();

    @Override
    public void addOrder(int theNumberOfTable, List<Integer> theListOfOrders) {

        // get table
        List<Integer> theTable = theTablesComponent.getMyRestaurant().get(theNumberOfTable);

        // add ordered list of products to table
        theTable.addAll(theListOfOrders);
    }

    @Override
    public void removeElementFromOrder(int theNumberOfTable, List<Integer> theListToRemove) {

        // get table
        List<Integer> theTable = theTablesComponent.getMyRestaurant().get(theNumberOfTable);

        // get all tables
        Map<Integer, List<Integer>> myRestaurant = theTablesComponent.getMyRestaurant();

        // create new integer list for order
        List<Integer> theNewOrderList;

        // filter order
        theNewOrderList = theTable.stream()
                .filter(x -> !isInListToRemove(x, theListToRemove))
                .collect(Collectors.toList());

        // set table after remove part of order
        myRestaurant.put(theNumberOfTable, theNewOrderList);


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
    public void acceptPaymentAndCleanOrder(int theNumberOfTable) {

        // get day
        Map<LocalDate, HashMap<Integer, Integer>> theDay = theDaySummaryComponent.getDay();

        // get table
        List<Integer> theTable = theTablesComponent.getMyRestaurant().get(theNumberOfTable);

        HashMap<Integer, Integer> listOfProductsWithQuantity = theMenuService.getListOfProductsWithQuantity();

        for (int i = 0; i < theTable.size(); i++) {
            int quantity=0;
            quantity = listOfProductsWithQuantity.get(theTable.get(i))+1;
            listOfProductsWithQuantity.put(theTable.get(i),quantity);
        }
        removeOrderWithoutAcceptPayment(theNumberOfTable);

    }

    // method to check if a product is on the list for removal
    boolean isInListToRemove(int x, List<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            if (x == list.get(i)) {
                list.remove(list.get(i));
                return true;
            }
        }
        return false;
    }

}
