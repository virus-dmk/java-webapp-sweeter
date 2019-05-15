package com.itransition.webapp.controller;

import com.itransition.webapp.domain.Message;
import com.itransition.webapp.domain.User;
import com.itransition.webapp.repos.MessageRepo;
import com.itransition.webapp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

@Controller
public class MainController {

//    @Autowired
//    private MessageRepo messageRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<User> users = userRepo.findAll();
        model.put("users", users);

        return "main";
    }

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

    @PostMapping("delete")
    public String delete(@RequestParam String filter, Map<String, Object> model) {
        deleteByUsername(splitFilter(filter));
        if (checkCurrentUserInFilter(splitFilter(filter)))
            return "redirect:/login?logout";
        model.put("users", userRepo.findAll());
        return "main";
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

//    @PostMapping("/main")
//    public String add(
//            @AuthenticationPrincipal User user,
//            @RequestParam String text,
//            @RequestParam String tag, Map<String, Object> model)
//    {
//        Message message = new Message(text, tag, user);
//        messageRepo.save(message);
//
//        Iterable<Message> messages = messageRepo.findAll();
//        model.put("messages", messages);
//
//        return "main";d
//    }

//    @PostMapping("filter")
//    public String filter(@RequestParam String filter, Map<String, Object> model){
//        Iterable<Message> messages;
//
//        if (filter != null && !filter.isEmpty()) {
//            messages = messageRepo.findByTag(filter);
//        } else{
//            messages = messageRepo.findAll();
//        }
//        model.put("messages", messages);
//        return "main";
//    }

}