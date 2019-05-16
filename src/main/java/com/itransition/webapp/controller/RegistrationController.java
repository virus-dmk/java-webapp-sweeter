package com.itransition.webapp.controller;

import com.itransition.webapp.domain.Role;
import com.itransition.webapp.domain.User;
import com.itransition.webapp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String reistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
//        User userFromDb = userRepo.findByUsername(user.getUsername());

        User userName = userRepo.findByUsername(user.getUsername());
        User userEmail = userRepo.findByEmail(user.getEmail());
        if(userName != null || userEmail != null){
            model.put("message", "Username or Email already exists!");
            return "registration";
        }


//        if (userFromDb != null) {
//            model.put("message", "User exists!");
//            return "registration";
//        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);


        return "redirect:/login";
    }
}
