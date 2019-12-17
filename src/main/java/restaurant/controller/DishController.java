package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.Entity.Dish;
import restaurant.service.DishService;

import java.util.List;

@Controller
@RequestMapping("/dish")
public class DishController {

    @Autowired
    DishService dishService;

    @GetMapping("/dishList")
    public String getAllDishes(Model model) {

        // get list all dishes
        List<Dish> listOfDishes = dishService.getListOfDishes();

        // add list of dishes to model
        model.addAttribute("listOfDishes", listOfDishes);

        return "dishes/dishes-list";
    }
}
