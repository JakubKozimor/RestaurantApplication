package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.Entity.Dish;
import restaurant.components.TablesComponent;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    TablesComponent theTablesComponent;
    @Autowired
    SummaryService theSummaryService;

    @Override
    public void addOrder(int theNumberOfTable, List<Dish> theListOfOrders) {
        if (theTablesComponent.getMyRestaurant(theNumberOfTable) == null) {
            theTablesComponent.addTable(theNumberOfTable);
        }
        List<Dish> theTable = theTablesComponent.getMyRestaurant(theNumberOfTable);
        theTable.addAll(theListOfOrders);
        theTablesComponent.setMyRestaurant(theNumberOfTable, theTable);
    }

    @Override
    public void removeElementFromOrder(int theNumberOfTable, List<Dish> theListToRemove) {
        List<Dish> theTable = theTablesComponent.getMyRestaurant(theNumberOfTable);
        List<Dish> afterRemove = theTable.stream()
                .filter(dish -> {
                    if (theListToRemove.contains(dish)) {
                        theListToRemove.remove(dish);
                        return false;
                    }
                    return true;
                })
                .collect(Collectors.toList());
        if (afterRemove.size() == 0) {
            theTablesComponent.removeTable(theNumberOfTable);
        } else {
            theTablesComponent.setMyRestaurant(theNumberOfTable,afterRemove);
        }

    }


    @Override
    public void removeOrderWithoutAcceptPayment(int theNumberOfTable) {
        theTablesComponent.removeTable(theNumberOfTable);

    }

    @Override
    public BigDecimal acceptPaymentAndCleanOrder(int theNumberOfTable) {
        theSummaryService.updateSummary(theNumberOfTable);
        BigDecimal sum = getMoneyForOrder(theNumberOfTable);
        theTablesComponent.removeTable(theNumberOfTable);
        return sum;
    }

    @Override
    public BigDecimal getMoneyForOrder(int theNumberOfTable) {
        BigDecimal sum = BigDecimal.valueOf(0);
        List<Dish> theTable = theTablesComponent.getMyRestaurant(theNumberOfTable);
        for (Dish tempDish : theTable) {
            sum = sum.add(tempDish.getPriceSell());
        }
        return sum;
    }
}
