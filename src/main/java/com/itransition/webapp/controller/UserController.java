package com.itransition.webapp.controller;

import com.itransition.webapp.domain.User;
import com.itransition.webapp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo userRepo;

//    @PreAuthorize()
    @GetMapping
    private String showUserPage(Map<String, Object> model){
        return "user";
    }


    @PostMapping("/usersList")
    public String showUsers(Map<String, Object> model, User user) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        if (!loggedInUser.isAuthenticated()) {

            return "login";
        }

        Iterable<User> users = userRepo.findAll();
        model.put("currentUser", loggedInUser.getName());
        model.put("usrs", users);
        return "usersAdminPanel";
    }

//    add filter for funfics урок добалсяем шаблонизатор



}
