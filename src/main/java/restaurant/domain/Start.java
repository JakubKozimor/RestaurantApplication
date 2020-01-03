package restaurant.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import restaurant.Entity.Dish;
import restaurant.components.TablesComponent;
import restaurant.dao.DishRepository;
import restaurant.dao.SummaryRepository;
import restaurant.service.RestaurantServiceImpl;
import restaurant.service.SummaryService;

import java.util.Calendar;
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
    @Autowired
    SummaryRepository summaryRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Dish> list = dishRepository.findAll();
        restaurantService.addOrder(12, list);
        restaurantService.addOrder(1, list);
        restaurantService.addOrder(5, list);

    }
}

