package restaurant.service;

import restaurant.components.TablesComponent;

import java.util.List;

public interface RestaurantService {

    void addOrder(int theNumberOfTable,List<Integer> theListOfOrders);

    void removeElementFromOrder(int theNumberOfTable, List<Integer> theListToRemove);

    void acceptPaymentAndCleanOrder(int theNumberOfTable);

    void removeOrderWithoutAcceptPayment(int theNumberOfTable);

}
