package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.Entity.Dish;
import restaurant.components.TablesComponent;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    TablesComponent tablesComponent;

    @GetMapping("/allTables")
    public String getAllTables(Model model) {

        // get all tables
        Map<Integer, List<Dish>> allTables = tablesComponent.getMyRestaurant();

        // add all tables to model
        model.addAttribute("allTables", allTables);

        return "restaurant/restaurant";
    }
}
