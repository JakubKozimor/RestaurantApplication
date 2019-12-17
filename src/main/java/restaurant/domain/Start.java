package restaurant.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import restaurant.Entity.Dish;
import restaurant.components.TablesComponent;
import restaurant.service.RestaurantServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Start implements CommandLineRunner {

    @Autowired
    RestaurantServiceImpl restaurantService;

    @Autowired
    TablesComponent tablesComponent;

    @Override
    public void run(String... args) throws Exception {



        // add order
        System.out.println("\nAdd\n");
        Dish dish1 = new Dish(1,"coffee",BigDecimal.valueOf(2),BigDecimal.valueOf(5));
        Dish dish2 = new Dish(2,"tea",BigDecimal.valueOf(1),BigDecimal.valueOf(3.33));
        List<Dish> listOfOrder = new ArrayList<>();
        listOfOrder.add(dish1);
        listOfOrder.add(dish1);
        listOfOrder.add(dish2);
        System.out.println(listOfOrder);
        System.out.println(tablesComponent.getMyRestaurant());
        restaurantService.addOrder(1,listOfOrder);
        System.out.println(tablesComponent.getMyRestaurant());
        System.out.println(tablesComponent.getMyRestaurant(1));

        // remove order
        System.out.println("\nRemove\n");
        System.out.println("Before");
        System.out.println(tablesComponent.getMyRestaurant(1));
        List<Dish> listToRemove = new ArrayList<>();
        listToRemove.add(dish1);
        listToRemove.add(dish2);
        restaurantService.removeElementFromOrder(1,listToRemove);
        System.out.println("After");
        System.out.println(tablesComponent.getMyRestaurant(1));

        // remove order without accept payment
        System.out.println("\nRemove without payment\n");
        System.out.println("Before");
        System.out.println(tablesComponent.getMyRestaurant(1));
        restaurantService.removeOrderWithoutAcceptPayment(1);
        System.out.println("After");
        System.out.println(tablesComponent.getMyRestaurant(1));

        // remove order and accept payment
        System.out.println("\nRemove with accept payment\n");
        System.out.println("Before");
        restaurantService.addOrder(1,listOfOrder);
        System.out.println(tablesComponent.getMyRestaurant(1));
        System.out.println("After");
        BigDecimal sum = restaurantService.acceptPaymentAndCleanOrder(1);
        System.out.println(tablesComponent.getMyRestaurant(1));
        System.out.println(sum);


    }
}

