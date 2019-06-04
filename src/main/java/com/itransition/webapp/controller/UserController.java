package com.itransition.webapp.controller;

import com.itransition.webapp.domain.*;
import com.itransition.webapp.repos.ChapterRepo;
import com.itransition.webapp.repos.CompositionRepo;
import com.itransition.webapp.repos.UserRepo;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    CompositionRepo compositionRepo;

    @Autowired
    ChapterRepo chapterRepo;

    //    @PreAuthorize()
    @GetMapping
    private String userPage(@AuthenticationPrincipal User authUser, Map<String, Object> model) {
        model.put("user", authUser);

        Iterable<Composition> compositions = compositionRepo.findAllByAuthorOrderByIdDesc(authUser);
        //Integer compositionChapterCount = chapterRepo.countChaptersByComposition(co)

        model.put("compositions", compositions);

        return "user";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user) {

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
        if(user.getRoles().isEmpty()){
            user.setRoles(Collections.singleton(Role.USER));
        }

        userRepo.save(user);


        return "redirect:/user";
    }


}
