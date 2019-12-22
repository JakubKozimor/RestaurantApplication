package restaurant.service;

import restaurant.Entity.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
    List<Dish> getListOfDishes();

    List<Dish> matchDishesById(List<Integer> listOfOrder);

    void saveDish(Dish dish);

    Optional<Dish> getSingleDish(int dishId);

}
