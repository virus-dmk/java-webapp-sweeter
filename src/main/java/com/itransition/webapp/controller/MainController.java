package com.itransition.webapp.controller;

import com.itransition.webapp.domain.User;
import com.itransition.webapp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@Controller
public class MainController {

//    @Autowired
//    private MessageRepo messageRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String userCheck(
            @RequestParam(name = "mainButton", required = false, defaultValue = "") String button,
            @RequestParam(name = "id", required = false, defaultValue = "") String[] id,
            Map<String, Object> model,
            User user) {

        System.out.println(Arrays.toString(id));

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();

        if (loggedInUser == null) {
            return "/login";
        }
        boolean loggedInUserDisabled = false;
        User userFromDb;

        if (button.equals("Sign Out")) {
            loggedInUser.setAuthenticated(false);
            return "redirect:/login?logout";
        }


        for (String userId : id) {

            if (userRepo.findById(Long.parseLong(userId)).isPresent()) {
                userFromDb = userRepo.findById(Long.parseLong(userId)).get();
                if (button.equals("active/block")) {
                    loggedInUserDisabled = isLoggedDisabled(userFromDb, loggedInUser);
                    setUserActiveOrBlock(userFromDb);

                }
                if (button.equals("delete")) {
                    loggedInUserDisabled = isLoggedDisabled(userFromDb, loggedInUser);
                    delete(userId);
                }
//                userRepo.save(userFromDb);
            }
        }

        if (loggedInUserDisabled) return "redirect:/login?logout";

//        showUsers(model);
        Iterable<User> users = userRepo.findAll();
        users = userRepo.findAll();
        model.put("currentUser", loggedInUser.getName());
        model.put("users", users);

        return "main";
    }

    @PostMapping
    public String showUsers(Map<String, Object> model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        if (!loggedInUser.isAuthenticated()) {
            return "/login";
        }

        Iterable<User> users = userRepo.findAll();
        users = userRepo.findAll();
        model.put("currentUser", loggedInUser.getName());
        model.put("users", users);
        return "main";
    }

    @RequestMapping("/login")
    public String login(Map<String, Object> model) {

        Iterable<User> users = userRepo.findAll();

        model.put("message", "Wrong data, or user not exists");
        return "login";
    }

//    @RequestMapping("/")
//    public String root(Map<String, Object> model) {
//
//        return "main";
//    }


    private boolean isLoggedDisabled(User usrFromDb, Authentication loggedInUsr) {
        if (usrFromDb.getUsername().equals(loggedInUsr.getName())) {
            return true;
        }
        return false;
    }

    private void setUserActiveOrBlock(User userFromDb) {
        if (userFromDb.isActive()) {
            userFromDb.setActive(false);
        } else {
            userFromDb.setActive(true);
        }
        userRepo.save(userFromDb);
    }

//    @GetMapping()
//    public String greeting(Map<String, Object> model) {
//        return "greeting";
//    }

//    @PostMapping("/main")
//    public String main(Map<String, Object> model) {
//        Iterable<User> users = userRepo.findAll();
//        model.put("users", users);
//        return "main";
//    }

    @PostMapping("block")
    public String block(@RequestParam String filter, Map<String, Object> model) {
        updateStatusByUsername(splitFilter(filter), false);
        if (checkCurrentUserInFilter(splitFilter(filter)))
            return "redirect:/login?logout";
        model.put("users", userRepo.findAll());
        return "main";
    }

    @PostMapping("unblock")
    public String unblock(@RequestParam String filter, Map<String, Object> model) {
        updateStatusByUsername(splitFilter(filter), true);
        model.put("users", userRepo.findAll());
        return "main";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect://login?logout";
    }

    public boolean delete(String id) {
        userRepo.deleteById(Long.parseLong(id));
        return true;
    }

    private void deleteByUsername(String[] filterArray) {
        for (String user : filterArray)
            userRepo.deleteByUsername(user);
    }

    private void updateStatusByUsername(String[] filterArray, Boolean status) {
        for (String user : filterArray)
            userRepo.updateUsrSetStatusForUsername(status, user);
    }

    private Boolean checkCurrentUserInFilter(String[] filterArray) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Arrays.asList(filterArray).contains(authentication.getName()))
            return true;
        return false;
    }

    private String[] splitFilter(String filter) {
        return filter.split(" ");
    }
}