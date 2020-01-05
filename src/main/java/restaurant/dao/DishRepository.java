package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import restaurant.entity.Dish;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Integer> {

    @Query(
            value = "SELECT * FROM dish WHERE old_dish=0",
            nativeQuery = true
    )
    List<Dish> findAllActualMenu();
}
