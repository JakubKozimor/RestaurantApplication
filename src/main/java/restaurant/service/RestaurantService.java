package restaurant.service;

import java.util.List;

public interface RestaurantService {

    void addOrder(int theNumberOfTable, List<Integer> theListOfOrders);

    void removeElementFromOrder(int theNumberOfTable, List<Integer> theListToRemove);

    double acceptPaymentAndCleanOrder(int theNumberOfTable);

    void removeOrderWithoutAcceptPayment(int theNumberOfTable);

}
