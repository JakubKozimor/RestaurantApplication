package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.Entity.Dish;
import restaurant.components.TablesComponent;
import restaurant.data.DishRepository;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    TablesComponent tablesComponent;
    @Autowired
    SummaryService summaryService;
    @Autowired
    DishRepository dishRepository;

    @Override
    public void addOrder(int theNumberOfTable, List<Dish> theListOfOrders) {
        if (tablesComponent.getMyRestaurant(theNumberOfTable) == null) {
            tablesComponent.addTable(theNumberOfTable);
        }
        List<Dish> theTable = tablesComponent.getMyRestaurant(theNumberOfTable);
        theTable.addAll(theListOfOrders);
        tablesComponent.setMyRestaurant(theNumberOfTable, theTable);
    }

    @Override
    public void removeElementFromOrder(int theNumberOfTable, List<Dish> theListToRemove) {
        List<Dish> theTable = tablesComponent.getMyRestaurant(theNumberOfTable);
        List<Dish> afterRemove = theTable.stream()
                .filter(dish -> {
                    for (Dish tempDish : theListToRemove) {
                        if (dish.getDishId() == tempDish.getDishId()) {
                            theListToRemove.remove(tempDish);
                            return false;
                        } else {
                            return true;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toList());
        if (afterRemove.size() == 0) {
            tablesComponent.removeTable(theNumberOfTable);
        } else {
            tablesComponent.setMyRestaurant(theNumberOfTable, afterRemove);
        }
    }

    @Override
    public void removeOrderWithoutAcceptPayment(int theNumberOfTable) {
        tablesComponent.removeTable(theNumberOfTable);

    }

    @Override
    public BigDecimal acceptPaymentAndCleanOrder(int theNumberOfTable) {
        summaryService.updateSummary(theNumberOfTable);
        BigDecimal sum = getMoneyForOrder(theNumberOfTable);
        tablesComponent.removeTable(theNumberOfTable);
        return sum;
    }

    @Override
    public BigDecimal getMoneyForOrder(int theNumberOfTable) {
        BigDecimal sum = BigDecimal.valueOf(0);
        List<Dish> theTable = tablesComponent.getMyRestaurant(theNumberOfTable);
        for (Dish tempDish : theTable) {
            sum = sum.add(tempDish.getPriceSell());
        }
        return sum;
    }

    @Override
    public List<Dish> getDishesByIds(List<Integer> listOfIds) {
        List<Dish> listOfDishes = new ArrayList<>();
        for (Integer tempId : listOfIds) {
            Optional<Dish> tempDish = dishRepository.findById(tempId);
            tempDish.ifPresent(listOfDishes::add);
        }
        return listOfDishes;
    }
}
