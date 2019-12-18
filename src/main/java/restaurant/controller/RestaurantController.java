package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import restaurant.Entity.Dish;
import restaurant.components.TablesComponent;
import restaurant.service.DishService;
import restaurant.service.RestaurantService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    TablesComponent tablesComponent;

    @Autowired
    DishService dishService;

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/allTables")
    public String getAllTables(Model model) {

        // get all tables
        Map<Integer, List<Dish>> allTables = tablesComponent.getMyRestaurant();


        // for test now
        List<Dish> listOfDishes = dishService.getListOfDishes();
        model.addAttribute("listOfDishes", listOfDishes);


        // add all tables to model
        model.addAttribute("allTables", allTables);

        return "restaurant/restaurant";
    }

    @PostMapping("/getOrder")
    public String getOrder(@RequestParam("numberOfTable") int numberOfTable, @RequestParam("order") List<Integer> listOfIdsOrderedDishes) {

        // get list of ordered dishes
        List<Dish> listOrderedDishes = dishService.matchDishesById(listOfIdsOrderedDishes);

        // add order
        restaurantService.addOrder(numberOfTable,listOrderedDishes);
        System.out.println(listOrderedDishes);
        System.out.println(numberOfTable);

        return "redirect:/restaurant/allTables";
    }
}
