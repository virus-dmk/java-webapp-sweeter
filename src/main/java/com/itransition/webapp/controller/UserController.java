package com.itransition.webapp.controller;

import com.itransition.webapp.domain.Composition;
import com.itransition.webapp.domain.Role;
import com.itransition.webapp.domain.User;
import com.itransition.webapp.repos.CompositionRepo;
import com.itransition.webapp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    CompositionRepo compositionRepo;

    //    @PreAuthorize()
    @GetMapping
    private String userPage(@AuthenticationPrincipal User authUser, Model model) {
        model.addAttribute("user", authUser);
//        model.addAttribute("authUser", authUser.getUsername());
        model.addAttribute("compositions", compositionRepo.findAllByUserId(authUser.getId()));
        return "user";
    }

    @PostMapping("/usersList")
    public String showUsers(Map<String, Object> model, User user) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        if (!loggedInUser.isAuthenticated()) {

            return "userAdminPanel";
        }

        Iterable<User> users = userRepo.findAll();
        model.put("currentUser", loggedInUser.getName());
        model.put("usrs", users);
        return "usersAdminPanel";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model ) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user){

        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);


return "redirect:/user";
    }
//    add filter for funfics урок добалсяем шаблонизатор


}
