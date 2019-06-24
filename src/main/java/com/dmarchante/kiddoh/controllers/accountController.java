package com.dmarchante.kiddoh.controllers;

import com.dmarchante.kiddoh.models.Account;
import com.dmarchante.kiddoh.repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class accountController {
    //Type of account available
    String[] accountType = {"Savings", "Checkings"};
    //Auto wire
    @Autowired
    AccountRepo accountRepo;
    @GetMapping("/addAccount")
    public String addAccount(Model m){
        m.addAttribute("accountType",accountType);
        return "account";
    }
    @PostMapping(value="/addAccount")
    public RedirectView addAccount(@RequestParam String name, String type, Float balance ){
        try{
            Account newAccount = new Account(name,type,balance);
            accountRepo.save(newAccount);
            return new RedirectView("account");
        }
        catch(Exception ex){
            return new RedirectView("/error");
        }
    }
}
