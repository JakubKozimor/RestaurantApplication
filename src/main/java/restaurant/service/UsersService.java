package restaurant.service;

import restaurant.entity.Users;

import java.util.Optional;

public interface UsersService {
    boolean saveUser(Users user, String role);

    Optional<Users> getUserByLogin(String username);
}
