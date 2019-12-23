package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.Entity.Dish;
import restaurant.data.DishRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    DishRepository dishRepository;

    @Override
    public List<Dish> getListOfDishes() {

        // return list of dishes
        return dishRepository.findAll();
    }

    @Override
    public List<Dish> matchDishesById(List<Integer> listOfOrder) {

        // return list of dishes
        return dishRepository.findAllById(listOfOrder);
    }

    @Override
    public void saveDish(Dish dish) {

        // save dish to database
        dishRepository.save(dish);
    }

    @Override
    public Optional<Dish> getSingleDish(int dishId) {

        // return single dish
        return dishRepository.findById(dishId);
    }

    @Override
    public void remove(int productId) {

        // delete product form database
        dishRepository.deleteById(productId);
    }
}
