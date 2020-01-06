package restaurant.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/firstPage")
public class FirstPageController {

    @GetMapping("/login")
    public String loginPage() {
        return "login/login-page";
    }

    @GetMapping("/firstPage")
    public void test(HttpServletResponse response) throws IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        if (role.contains("WAITER")) {
            response.sendRedirect("/restaurant/restaurantRoom");
        } else {
            if (role.contains("MANAGER")) {
                response.sendRedirect("/dish/dishList");
            } else {
                if (role.contains("ADMIN")) {
                    response.sendRedirect("/users/allUsers");
                } else {
                    response.sendRedirect("/firstPage/login");
                }
            }
        }
    }
}
