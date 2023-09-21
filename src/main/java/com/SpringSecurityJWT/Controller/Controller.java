package com.SpringSecurityJWT.Controller;

import com.SpringSecurityJWT.Model.User;
import com.SpringSecurityJWT.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class Controller {

    @Autowired
    private Service service;

    /**
     * This endpoint retrieves a list of users.
     * It uses the Service class to fetch the list of users and returns it as a response.
     * @return List of User objects
     */
    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getUsers();
    }

    /**
     * This endpoint retrieves the username of the currently authenticated user.
     * It takes a Principal object as a parameter, which represents the authenticated user.
     * It returns the username of the authenticated user.
     * @param principal Principal object representing the authenticated user
     * @return Username of the authenticated user
     */
    @GetMapping("/current-user")
    public String getCurrentUser(Principal principal) {
        return principal.getName();
    }
}
