package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.entity.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities,Integer> {
}
