package restaurant.data;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.Entity.Summary;

public interface SummaryRepository extends JpaRepository<Summary, Integer> {
}
