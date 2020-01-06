package restaurant.controller;

import org.eclipse.jdt.internal.compiler.apt.model.ErrorTypeElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import restaurant.entity.Authorities;
import restaurant.entity.Users;
import restaurant.service.AuthoritiesService;
import restaurant.service.UsersService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    AuthoritiesService authoritiesService;
    @Autowired
    UsersService usersService;

    @GetMapping("/allUsers")
    public String getAllUsers(Model model) {
        List<Authorities> listOfUsers = authoritiesService.getListOfAuthorities();
        model.addAttribute("listOfUsers", listOfUsers);
        return "/users/list-of-users";
    }

    @GetMapping("/showFormForAddUser")
    public String showFormForAddUser(Model model) {
        Users user = new Users();
        Authorities authorities = new Authorities();
        model.addAttribute("user", user);
        model.addAttribute("authorities", authorities);
        return "/users/add-user-form";
    }

    @PostMapping("/saveUser")
    public String addUser(@Valid @ModelAttribute("user") Users user,
                          @RequestParam("role") String role, BindingResult bindingResult) {
        if (!usersService.saveUser(user, role)) {
            bindingResult.addError(new FieldError("username","username","Użytkownik już istnieje"));
            return "users/add-user-form";
        } else {
            return "redirect:/users/allUsers";
        }

    }
}