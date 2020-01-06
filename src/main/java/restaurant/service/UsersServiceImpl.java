package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import restaurant.dao.AuthoritiesRepository;
import restaurant.dao.UsersRepository;
import restaurant.entity.Authorities;
import restaurant.entity.Users;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    AuthoritiesRepository authoritiesRepository;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public boolean saveUser(Users user, String role) {
        StringBuilder password = new StringBuilder("{bcrypt}").append(passwordEncoder.encode(user.getPassword()));
        Optional<Users> isNew = usersRepository.findById(user.getUsername());
        Optional<Authorities> isToUpdate = authoritiesRepository.findByUsername(user);
        if (!isNew.isPresent()) {
            return saveNewUser(user, role, password);
        } else {
            if (role == null) {
                return updateUser(isToUpdate, user, password);
            } else {
                return false;
            }
        }
    }

    public boolean saveNewUser(Users user, String role, StringBuilder password) {
        user.setPassword(password.toString());
        user.setEnabled(1);
        Authorities authorities = new Authorities();
        authorities.setUsername(user);
        authorities.setAuthority(role);
        usersRepository.save(user);
        authoritiesRepository.save(authorities);
        return true;
    }

    public boolean updateUser(Optional<Authorities> isToUpdate, Users user, StringBuilder password) {
        isToUpdate.ifPresent(authorities -> {
            user.setEnabled(1);
            user.setPassword(password.toString());
            authorities.setUsername(user);
            usersRepository.save(user);
            authoritiesRepository.save(authorities);
        });
        return true;
    }

    @Override
    public Optional<Users> getUserByLogin(String username) {
        return usersRepository.findById(username);
    }
}
