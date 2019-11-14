package restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import restaurant.Entity.Products;
import restaurant.components.DateComponent;
import restaurant.components.DaySummaryComponent;
import restaurant.components.TablesComponent;
import restaurant.service.MenuService;
import restaurant.service.RestaurantService;

import java.time.LocalDate;
import java.util.*;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    DateComponent theDateComponent;

    @Autowired
    TablesComponent theTablesComponent;

    @Autowired
    RestaurantService theRestaurantService;

    @Autowired
    MenuService theMenuService;

    @Autowired
    DaySummaryComponent theDaySummaryComponent;

    @Override
    public void run(String... args) throws Exception {

        // only get a date
        System.out.println(theDateComponent.getDate());

        // try add order
        List<Integer> order = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 2));
        // table at start
        System.out.println(theTablesComponent.getMyRestaurant().get(1));
        theRestaurantService.addOrder(1, order);
        // table after first order
        System.out.println(theTablesComponent.getMyRestaurant().get(1));

        // try to remove part of order
        List<Integer> listToRemove = new ArrayList<>(Arrays.asList(3, 4, 5, 2));
        theRestaurantService.removeElementFromOrder(1, listToRemove);
        // table after remove part of order
        System.out.println(theTablesComponent.getMyRestaurant().get(1));

        // try to remove order without accept payment
        theRestaurantService.removeOrderWithoutAcceptPayment(1);
        // table after remove order
        System.out.println(theTablesComponent.getMyRestaurant().get(1));

        // add order
        System.out.println("Dodano zamówienie");
        theRestaurantService.addOrder(1, order);
        // table after add order
        System.out.println(theTablesComponent.getMyRestaurant().get(1));

        HashMap<Integer, Integer> listOfProductsWithQuantity = new HashMap<>();
        Products product1 = new Products(1, "pizza", 25.50, 32.50);
        Products product2 = new Products(2, "kebab", 8.20, 12);
        Products product3 = new Products(3, "piwo", 2, 6);
        Products product4 = new Products(4, "piwo", 2, 6);
        Products product5 = new Products(5, "piwo", 2, 6);
        listOfProductsWithQuantity.put(product1.getProductId(), 0);
        listOfProductsWithQuantity.put(product2.getProductId(), 0);
        listOfProductsWithQuantity.put(product3.getProductId(), 0);
        listOfProductsWithQuantity.put(product4.getProductId(), 0);
        listOfProductsWithQuantity.put(product5.getProductId(), 0);

        Map<LocalDate, HashMap<Integer, Integer>> tempday = new HashMap<>();

        tempday.put(theDateComponent.getDate(),listOfProductsWithQuantity);
        theDaySummaryComponent.setDay(tempday);

        // check summary of day
        System.out.println("Pusty raport dnia");
        System.out.println(theDaySummaryComponent.getDay());
        System.out.println("data");
        System.out.println(theDateComponent.getDate());
        System.out.println("lista z id i ilością ");
        System.out.println(theMenuService.getListOfProductsWithQuantity());



        // try to accept payment and clean order
        theRestaurantService.acceptPaymentAndCleanOrder(1);
        System.out.println("lista z ilością zakupionych produktów");
        System.out.println(theMenuService.getListOfProductsWithQuantity());
        System.out.println("zamówienie");
        System.out.println(theTablesComponent.getMyRestaurant().get(1));



    }




}
