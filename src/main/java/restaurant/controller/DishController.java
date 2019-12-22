package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import restaurant.Entity.Dish;
import restaurant.Entity.Inventory;
import restaurant.service.DishService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/dishEditList")
    public String dishEditList(Model model) {

        // get list all dishes
        List<Dish> listOfDishes = dishService.getListOfDishes();

        // add list of dishes to model
        model.addAttribute("listOfDishes", listOfDishes);

        return "dishes/dishes-edit-list";
    }

    @GetMapping("/showFormForAddDish")
    public String showFormForAddDish(Model model) {

        // create empty object
        Dish dish = new Dish();

        // add empty object to model
        model.addAttribute("dish", dish);

        return "/dishes/dish-form";
    }

    @PostMapping("/saveDish")
    public String saveDish(@Valid @ModelAttribute("dish") Dish dish, BindingResult bindingResult) {
// check errors if not errors save product if not back to form for add
        if (bindingResult.hasErrors()) {
            return "dishes/dish-form";
        } else {

            // save product
            dishService.saveDish(dish);

            // redirect to list of products
            return "redirect:/dish/dishEditList";
        }
    }

    @GetMapping("/showFormForUpdateDish")
    public String showFormForUpdateDish(@RequestParam("dishId") int dishId, Model model) {

        // get product
        Optional<Dish> theDish = dishService.getSingleDish(dishId);

        // theDish is always present
        theDish.ifPresent(dish ->{

            // set product as a model attribute
            model.addAttribute("dish", theDish);

        });

        return "/dishes/dish-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("dishId") int dishId) {

        // remove product
        dishService.remove(dishId);

        // redirect to form for edit product
        return "redirect:/dish/dishEditList";
    }
}
