package restaurant.service;

import restaurant.entity.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {

    List<Dish> getListOfDishes();

    void saveDish(Dish dish);

    Optional<Dish> getSingleDish(int dishId);

    void remove(int dishId);
}
