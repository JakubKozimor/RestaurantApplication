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
        Map<Integer, List<Dish>> allTables = tablesComponent.getMyRestaurant();
        List<Dish> listOfDishes = dishService.getListOfDishes();
        model.addAttribute("listOfDishes", listOfDishes);
        model.addAttribute("allTables", allTables);
        return "restaurant/restaurant";
    }

    @PostMapping("/getOrder")
    public String getOrder(@RequestParam("numberOfTable") int numberOfTable, @RequestParam("order") List<Integer> listOfIdsOrderedDishes) {
        List<Dish> listOrderedDishes = dishService.matchDishesById(listOfIdsOrderedDishes);
        restaurantService.addOrder(numberOfTable, listOrderedDishes);
        return "redirect:/restaurant/allTables";
    }

    @GetMapping("/restaurantRoom")
    public String restaurantRoom() {
        return "/restaurant/restaurant-room";
    }

    @GetMapping("/orderOfTable")
    public String orderOfTable(@RequestParam("tableId") int tableId) {
        System.out.println(tableId);
        return "redirect:/restaurant/restaurantRoom";
    }
}
