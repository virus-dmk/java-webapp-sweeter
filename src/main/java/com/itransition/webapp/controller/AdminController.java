package com.itransition.webapp.controller;

import com.itransition.webapp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/admin")
public class AdminController {

    @Autowired
    UserRepo userRepo;


    public String editUser(Model model){

        return "dd";
    }

}
