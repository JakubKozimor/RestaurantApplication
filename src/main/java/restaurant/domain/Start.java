package restaurant.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import restaurant.service.RestaurantServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Start implements CommandLineRunner {

    @Autowired
    RestaurantServiceImpl restaurantService;

    @Override
    public void run(String... args) throws Exception {

        List<Integer> listOfOrder = new ArrayList<>(Arrays.asList(1, 2));
        restaurantService.addOrder(1, listOfOrder);
        System.out.println(restaurantService.acceptPaymentAndCleanOrder(1));


    }
}

