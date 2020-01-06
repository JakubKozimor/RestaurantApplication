package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import restaurant.dao.AuthoritiesRepository;
import restaurant.dao.UsersRepository;
import restaurant.entity.Authorities;
import restaurant.entity.Users;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    AuthoritiesRepository authoritiesRepository;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void saveUser(Users user, String role) {
        StringBuilder password = new StringBuilder("{bcrypt}").append(passwordEncoder.encode(user.getPassword()));
        user.setPassword(password.toString());
        user.setEnabled(1);
        Authorities authorities = new Authorities();
        authorities.setUsername(user);
        authorities.setAuthority(role);
        usersRepository.save(user);
        authoritiesRepository.save(authorities);
    }
}
