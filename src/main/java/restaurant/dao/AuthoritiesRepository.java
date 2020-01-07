package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import restaurant.entity.Authorities;
import restaurant.entity.Users;

import java.util.List;
import java.util.Optional;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer> {

    Optional<Authorities> findByUsername(Users user);

    @Query(
            value = "SELECT * FROM authorities where authority = :roleParam",
            nativeQuery = true
    )
    List<Authorities> getListOfAuthority(@Param("roleParam") String roleParam);

}
