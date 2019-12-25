package restaurant.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import restaurant.Entity.Dish;
import restaurant.components.TablesComponent;
import restaurant.data.DishRepository;
import restaurant.service.RestaurantServiceImpl;
import restaurant.service.SummaryService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class Start implements CommandLineRunner {

    @Autowired
    RestaurantServiceImpl restaurantService;
    @Autowired
    TablesComponent tablesComponent;
    @Autowired
    SummaryService summaryService;
    @Autowired
    DishRepository dishRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Dish> list = dishRepository.findAll();
        restaurantService.addOrder(1, list);

    }
}

