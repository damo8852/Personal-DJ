package com.personaldj.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {

    @GetMapping("/library")
    public String library(Model model) {
        model.addAttribute("pageTitle", "Personal DJ — Library");
        return "library";
    }
}
