package restaurant.service;

import restaurant.entity.Users;

public interface UsersService {
    boolean saveUser(Users user, String role);
}
