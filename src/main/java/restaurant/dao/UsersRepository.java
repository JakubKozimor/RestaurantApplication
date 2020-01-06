package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
}
