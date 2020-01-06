package restaurant.service;

import restaurant.entity.Users;

public interface UsersService {
    void saveUser(Users user, String role);
}
