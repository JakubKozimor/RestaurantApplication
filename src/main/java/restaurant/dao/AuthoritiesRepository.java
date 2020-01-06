package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.entity.Authorities;
import restaurant.entity.Users;

import java.util.Optional;

public interface AuthoritiesRepository extends JpaRepository<Authorities,Integer> {
    Optional<Authorities> findByUsername(Users user);
}
