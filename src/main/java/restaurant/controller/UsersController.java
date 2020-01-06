package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.entity.Authorities;
import restaurant.service.AuthoritiesService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    AuthoritiesService authoritiesService;

    @GetMapping("/allUsers")
    public String getAllUsers(Model model) {
        List<Authorities> listOfUsers = authoritiesService.getListOfAuthorities();
        model.addAttribute("listOfUsers", listOfUsers);
        return "/users/list-of-users";
    }
}