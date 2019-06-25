package com.dmarchante.kiddoh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KidDohController {

    @GetMapping("/")
    public String getHomePage(@RequestParam (required = false, defaultValue = "")String error, Model m){
        m.addAttribute("error", error);
        return "Home";
    }
}
