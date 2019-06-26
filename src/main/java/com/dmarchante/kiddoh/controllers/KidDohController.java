package com.dmarchante.kiddoh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class KidDohController {

    @GetMapping("/")
    public String getHomePage(Model m, Principal p){
        m.addAttribute("principal", p);
        return p == null ? "login" : "tempAccounts"; //TODO change this to accounts
    }

    @GetMapping("/signup")
    public String getSignUpPage(@RequestParam (required = false, defaultValue = "")String error, Model m, Principal p){
        m.addAttribute("principal", p);
        m.addAttribute("error", error);
        return "signUp";
    }

    @GetMapping("/login")
    public String logIn(){
        return "login";
    }
}
