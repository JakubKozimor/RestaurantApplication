package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.dao.AuthoritiesRepository;
import restaurant.entity.Authorities;

import java.util.List;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Override
    public List<Authorities> getListOfAuthorities() {
        return authoritiesRepository.findAll();
    }

}
