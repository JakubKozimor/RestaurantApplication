package restaurant.data;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.Entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}
