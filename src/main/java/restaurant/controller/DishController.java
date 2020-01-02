package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import restaurant.Entity.Dish;
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
        List<Dish> listOfDishes = dishService.getListOfDishes();
        model.addAttribute("listOfDishes", listOfDishes);
        return "dishes/dishes-list";
    }

    @GetMapping("/dishEditList")
    public String dishEditList(Model model) {
        List<Dish> listOfDishes = dishService.getListOfDishes();
        model.addAttribute("listOfDishes", listOfDishes);
        return "dishes/dishes-edit-list";
    }

    @GetMapping("/showFormForAddDish")
    public String showFormForAddDish(Model model) {
        Dish dish = new Dish();
        model.addAttribute("dish", dish);
        return "/dishes/dish-form";
    }

    @PostMapping("/saveDish")
    public String saveDish(@Valid @ModelAttribute("dish") Dish dish, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "dishes/dish-form";
        } else {
            dishService.saveDish(dish);
            return "redirect:/dish/dishEditList";
        }
    }

    @GetMapping("/showFormForUpdateDish")
    public String showFormForUpdateDish(@RequestParam("dishId") int dishId, Model model) {
        Optional<Dish> theDish = dishService.getSingleDish(dishId);
        theDish.ifPresent(dish ->{
            model.addAttribute("dish", theDish);
        });
        return "/dishes/dish-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("dishId") int dishId) {
        dishService.remove(dishId);
        return "redirect:/dish/dishEditList";
    }
}
