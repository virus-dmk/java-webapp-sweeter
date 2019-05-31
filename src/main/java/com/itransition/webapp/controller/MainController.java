package com.itransition.webapp.controller;

import com.itransition.webapp.domain.User;
import com.itransition.webapp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller

public class MainController {

    //    @Autowired
//    private MessageRepo messageRepo;


    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    private String index(Map<String, Object> model) {
        return "redirect:/index";
    }


    @GetMapping("/index")
    private String getIndex(Map<String, Object> model, @AuthenticationPrincipal User loggedUser) {
//        Authentication loggedUser = SecurityContextHolder.getContext().getAuthentication();
        if (loggedUser != null) {
            model.put("loggedUser", loggedUser.getUsername() + " " + loggedUser.getRoles());
        } else
        {
            model.put("loggedUser", "Not reg");
        }
            return "index";
    }

    @PostMapping("/index")
    private String postIndex(Map<String, Object> model) {
        Authentication loggedUser = SecurityContextHolder.getContext().getAuthentication();
        model.put("loggedUser", loggedUser.getName());
        return "index";
    }

    @GetMapping("/index2")
    private String index2() {
        return "index2";
    }



}