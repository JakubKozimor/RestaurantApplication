package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import restaurant.Entity.Dish;
import restaurant.components.TablesComponent;
import restaurant.service.DishService;
import restaurant.service.RestaurantService;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    @GetMapping("/restaurantRoom")
    public String restaurantRoom() {
        return "/restaurant/restaurant-room";
    }

    @GetMapping("/orderOfTable")
    public String orderOfTable(@RequestParam("tableId") int tableId, Model model) {
        List<Dish> listOfOrder = tablesComponent.getMyRestaurant(tableId);
        List<Dish> listOfDishes = dishService.getListOfDishes();
        BigDecimal moneyForOrder = restaurantService.getMoneyForOrder(tableId);
        model.addAttribute("order", listOfOrder);
        model.addAttribute("listOfDishes", listOfDishes);
        model.addAttribute("money", moneyForOrder);
        model.addAttribute("numberOfTable", tableId);
        return "/restaurant/order-of-table";
    }

    @GetMapping("/removeWithoutAcceptPayment")
    public String removeWithoutAcceptPayment(@RequestParam("tableId") int tableId, RedirectAttributes redirectAttributes) {
        restaurantService.removeOrderWithoutAcceptPayment(tableId);
        redirectAttributes.addAttribute("tableId", tableId);
        return "redirect:/restaurant/orderOfTable";
    }

    @PostMapping("/addToOrder")
    public String addOrder(@RequestParam(value = "listToAdd", required = false) List<Integer> listToAdd,
                           @RequestParam(value = "tableId") int tableId ,RedirectAttributes redirectAttributes) {
        if (listToAdd != null) {
            List<Dish> listOfDishes = restaurantService.getDishesByIds(listToAdd);
            restaurantService.addOrder(tableId, listOfDishes);
        }
        redirectAttributes.addAttribute("tableId",tableId);
        return "redirect:/restaurant/orderOfTable";
    }

    @PostMapping("/removeFromOrder")
    public String removeFromOrder(@RequestParam(value = "order", required = false) List<Integer> listOfOrderToRemove,
                                  @RequestParam(value = "tableId") int tableId, RedirectAttributes redirectAttributes) {
        if (listOfOrderToRemove != null) {
            List<Dish> listOfDishes = restaurantService.getDishesByIds(listOfOrderToRemove);
            restaurantService.removeElementFromOrder(tableId, listOfDishes);
        }
        redirectAttributes.addAttribute("tableId",tableId);
        return "redirect:/restaurant/orderOfTable";
    }


}
