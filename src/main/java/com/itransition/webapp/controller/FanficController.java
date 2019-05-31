package com.itransition.webapp.controller;

import com.itransition.webapp.domain.Chapter;
import com.itransition.webapp.domain.Composition;
import com.itransition.webapp.domain.Genre;
import com.itransition.webapp.domain.User;
import com.itransition.webapp.repos.ChapterRepo;
import com.itransition.webapp.repos.CompositionRepo;
import com.itransition.webapp.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class FanficController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    CompositionRepo compositionRepo;

    @Autowired
    ChapterRepo chapterRepo;


    @GetMapping("/createFanfic")
    public String createFanfic(Model model) {

        return "createFanfic";
    }

    @PostMapping("/createFanfic")
    public String saveFanfic(
            @AuthenticationPrincipal User authUser,
            @RequestParam(name = "fanficName", required = false, defaultValue = "") String fanficName,
            @RequestParam(name = "fanficDescription", required = false, defaultValue = "") String fanficDescription,
//            @RequestParam String chapter_id,
            @RequestParam Map<String, String> form, Composition composition) {


//        Composition composition = new Composition(authUser, fanficName, fanficDescription, Genre.NONE);

        composition.setAuthor((User) authUser);
        composition.setGenres(Collections.singleton(Genre.NONE));
        composition.setDescription(fanficDescription);
        composition.setCompos_name(fanficName);
        compositionRepo.save(composition);

        Set<String> genres = Arrays.stream(Genre.values())
                .map(Genre::name)
                .collect(Collectors.toSet());

//        composition.getGenres().clear();

        Set<Genre> listGenres = new HashSet<>();
        for (String key : form.keySet()) {
            if (genres.contains(key)) {
                listGenres.add(Genre.valueOf(key));
            }
        }
        composition.setGenres(listGenres);


        compositionRepo.save(composition);


        return "redirect:/user";
    }

    @GetMapping(value = "/composition/{composition}")
    public String showFanfic(@PathVariable Composition composition, Map<String, Object> model, Chapter chapter) {
        Iterable<Chapter> chapters = chapterRepo.findAllByComposition(composition);

        model.put("composition", composition);
        model.put("chapters", chapters);
        return "composition";
    }

    @GetMapping(value = "/composition/{composition}/createChapterPage")
    public String createChapterPage(@PathVariable Composition composition) {

        return "createChapterForm";
    }

    @RequestMapping(value = "/composition/{composition}/createChapter")
    public String createChapter(
            @PathVariable Composition composition,
            Model model,
            Chapter chapter,
            @RequestParam(name = "chapterName", required = false, defaultValue = "") String chapterName,
            @RequestParam(name = "chapterNumber", required = false) Integer chapterNumber,
            @RequestParam(name = "chapterText", required = false, defaultValue = "") String chapterText
    ) {
        chapter = new Chapter(chapterName, chapterNumber, chapterText, composition);

        chapterRepo.save(chapter);

        return "redirect:/user/composition/" + composition.getId();
    }

    @PostMapping(value = "/composition/deleteComposition={pathComposition}")
    public String deleteComposition(
            @PathVariable Composition pathComposition,
            @RequestParam(name = "deleteCompositionId") Composition composition
    ){
        compositionRepo.delete(composition);

        return "/redirect:/user";
    }
}
