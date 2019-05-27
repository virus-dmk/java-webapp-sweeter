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


//
//
//    @PostMapping("/usersAdminPanel")
//    public String usersAdministrationPanel(Map<String, Object> model) {
//        Iterable<User> users = userRepo.findAll();
//        model.put("users", users);
//        return "usersAdminPanel";
//    }

    ////    @PostMapping("/main")
////    public String main(Map<String, Object> model) {
////        Iterable<User> users = userRepo.findAll();
////        model.put("users", users);
////        return "main";
////    }


//    @GetMapping("/pas")
//    public String userCheck(
//            @RequestParam(name = "mainButton", required = false, defaultValue = "") String button,
//            @RequestParam(name = "id", required = false, defaultValue = "") String[] id,
//            Map<String, Object> model) {
//
//        System.out.println(Arrays.toString(id));
//
//        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//
//        if (loggedInUser == null) {
//            return "/login";
//        }
//        boolean loggedInUserDisabled = false;
//        User userFromDb;
//
//        if (button.equals("Sign Out")) {
//            loggedInUser.setAuthenticated(false);
//            return "redirect:/login?logout";
//        }
//
//
//        for (String userId : id) {
//
//            if (userRepo.findById(Long.parseLong(userId)).isPresent()) {
//                userFromDb = userRepo.findById(Long.parseLong(userId)).get();
//                if (button.equals("active/block")) {
//                    loggedInUserDisabled = isLoggedDisabled(userFromDb, loggedInUser);
//                    setUserActiveOrBlock(userFromDb);
//
//                }
//                if (button.equals("delete")) {
//                    loggedInUserDisabled = isLoggedDisabled(userFromDb, loggedInUser);
//                    delete(userId);
//                }
////                userRepo.save(userFromDb);
//            }
//        }
//
//        if (loggedInUserDisabled) {
//            loggedInUser.setAuthenticated(false);
//            return "redirect:/login?logout";
//        }
//
////        showUsers(model);
//        Iterable<User> users = userRepo.findAll();
//        users = userRepo.findAll();
//        model.put("currentUser", loggedInUser.getName());
//        model.put("users", users);
//
//        return "main";
//    }
//

//

//

//
//
//    private boolean isLoggedDisabled(User usrFromDb, Authentication loggedInUsr) {
//        if (usrFromDb.getUsername().equals(loggedInUsr.getName())) {
//            return true;
//        }
//        return false;
//    }
//
//    private void setUserActiveOrBlock(User userFromDb) {
//        if (userFromDb.isActive()) {
//            userFromDb.setActive(false);
//        } else {
//            userFromDb.setActive(true);
//        }
//        userRepo.save(userFromDb);
//    }

//

//
//    @PostMapping("block")
//    public String block(@RequestParam String filter, Map<String, Object> model) {
//        updateStatusByUsername(splitFilter(filter), false);
//        if (checkCurrentUserInFilter(splitFilter(filter)))
//            return "redirect:/login?logout";
//        model.put("users", userRepo.findAll());
//        return "main";
//    }
//
//    @PostMapping("unblock")
//    public String unblock(@RequestParam String filter, Map<String, Object> model) {
//        updateStatusByUsername(splitFilter(filter), true);
//        model.put("users", userRepo.findAll());
//        return "main";
//    }
//
//    @PostMapping("/logout")
//    public String logout() {
//        return "redirect://login?logout";
//    }
//
//    public boolean delete(String id) {
//        userRepo.deleteById(Long.parseLong(id));
//        return true;
//    }
//
//    private void deleteByUsername(String[] filterArray) {
//        for (String user : filterArray)
//            userRepo.deleteByUsername(user);
//    }
//
//    private void updateStatusByUsername(String[] filterArray, Boolean status) {
//        for (String user : filterArray)
//            userRepo.updateUsrSetStatusForUsername(status, user);
//    }
//
//    private Boolean checkCurrentUserInFilter(String[] filterArray) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (Arrays.asList(filterArray).contains(authentication.getName()))
//            return true;
//        return false;
//    }
//
//    private String[] splitFilter(String filter) {
//        return filter.split(" ");
//    }
}