package restaurant.service;

import restaurant.Entity.Dish;

import java.math.BigDecimal;
import java.util.List;

public interface RestaurantService {

    void addOrder(int theNumberOfTable, List<Dish> theListOfOrders);

    void removeElementFromOrder(int theNumberOfTable, List<Dish> theListToRemove);

    void removeOrderWithoutAcceptPayment(int theNumberOfTable);

    BigDecimal acceptPaymentAndCleanOrder(int theNumberOfTable);

}
