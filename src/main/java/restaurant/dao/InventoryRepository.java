package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.Entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
