package restaurant.service;

import restaurant.Entity.Dish;

import java.util.List;

public interface DishService {
    List<Dish> getListOfDishes();

    List<Dish> matchDishesById(List<Integer> listOfOrder);
}
