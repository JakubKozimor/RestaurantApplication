package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
