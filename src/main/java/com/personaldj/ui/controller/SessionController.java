package com.personaldj.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

    @GetMapping("/session")
    public String session(Model model) {
        model.addAttribute("pageTitle", "Personal DJ — Session");
        return "session";
    }
}
