package restaurant.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import restaurant.Entity.Dish;
import restaurant.Entity.Inventory;
import restaurant.components.DateComponent;
import restaurant.components.DaySummaryComponent;
import restaurant.components.TablesComponent;
import restaurant.service.InventoryService;
import restaurant.service.MenuService;
import restaurant.service.RestaurantService;

import java.time.LocalDate;
import java.util.*;


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

    @Autowired
    InventoryService theInventoryService;

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
        Dish product1 = new Dish(1, "pizza", 25.50, 32.50);
        Dish product2 = new Dish(2, "kebab", 8.20, 12);
        Dish product3 = new Dish(3, "piwo", 2, 6);
        Dish product4 = new Dish(4, "piwo", 2, 6);
        Dish product5 = new Dish(5, "piwo", 2, 6);
        listOfProductsWithQuantity.put(product1.getDishId(), 0);
        listOfProductsWithQuantity.put(product2.getDishId(), 0);
        listOfProductsWithQuantity.put(product3.getDishId(), 0);
        listOfProductsWithQuantity.put(product4.getDishId(), 0);
        listOfProductsWithQuantity.put(product5.getDishId(), 0);

        Map<LocalDate, HashMap<Integer, Integer>> tempday = new HashMap<>();

        tempday.put(theDateComponent.getDate(),listOfProductsWithQuantity);
        theDaySummaryComponent.setDay(tempday);

        // check summary of day
        System.out.println("Pusty raport dnia");
        System.out.println(theDaySummaryComponent.getDay());
        System.out.println("data");
        System.out.println(theDateComponent.getDate());
        System.out.println("lista z id i ilością ");
        System.out.println(theMenuService.getListOfDishWithQuantity());



        // try to accept payment and clear order
        theRestaurantService.acceptPaymentAndCleanOrder(1);
        System.out.println("lista z ilością zakupionych produktów");
        System.out.println(theMenuService.getListOfDishWithQuantity());
        System.out.println("zamówienie");
        System.out.println(theTablesComponent.getMyRestaurant().get(1));

        // summary of all days
        Map<LocalDate, HashMap<Integer, Integer>> day = theDaySummaryComponent.getDay();
        System.out.println(day);

        // try add second order
        theRestaurantService.addOrder(1, order);
        System.out.println(theTablesComponent.getMyRestaurant().get(1));

        // try to accept payment and clear order
        theRestaurantService.acceptPaymentAndCleanOrder(1);
        System.out.println("lista z ilością zakupionych produktów po drugim zamówieniu");
        System.out.println(theMenuService.getListOfDishWithQuantity());
        System.out.println("zamówienie");
        System.out.println(theTablesComponent.getMyRestaurant().get(1));

        // summary of all days
        System.out.println(day);


        // det inventory
        List<Inventory> inventory = theInventoryService.getListOfProducts();
        System.out.println("Zaopatrzenie na początku");
        System.out.println(inventory);

        theInventoryService.removeFromInventory(1,1);

        List<Inventory> inventoryAfterRemove = theInventoryService.getListOfProducts();
        System.out.println("Zaopatrzenie po usunięciu");
        System.out.println(inventoryAfterRemove);

        List<Inventory> inventory1 = theInventoryService.getListOfProducts();
        System.out.println("Zaopatrzenie przed dodaniem");
        System.out.println(inventory1);

        theInventoryService.addToInventory(1,1);

        List<Inventory> inventoryAfterAdd = theInventoryService.getListOfProducts();
        System.out.println("Zaopatrzenie po dodaniu");
        System.out.println(inventoryAfterRemove);
    }




}
