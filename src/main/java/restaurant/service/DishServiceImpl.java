package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.Entity.Dish;
import restaurant.data.DishRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    DishRepository dishRepository;

    @Override
    public List<Dish> getListOfDishes() {

        return dishRepository.findAll();
    }

    @Override
    public List<Dish> matchDishesById(List<Integer> listOfOrder) {

        return dishRepository.findAllById(listOfOrder);
    }
}
