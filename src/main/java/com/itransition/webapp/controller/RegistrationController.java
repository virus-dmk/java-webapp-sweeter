package com.itransition.webapp.controller;

import com.itransition.webapp.domain.Role;
import com.itransition.webapp.domain.User;
import com.itransition.webapp.repos.UserRepo;
import com.itransition.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    private final UserService userService;

    private final UserRepo userRepo;

    @Autowired
    public RegistrationController(UserService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();


        if(!userService.createUser(user)){
            model.put("message", "Username or Email already exists!");
            return "redirect:/registration";
        }
        System.out.println("user "+ loggedInUser.getName()+ "logged in");
        return "redirect:/login";
    }
}
