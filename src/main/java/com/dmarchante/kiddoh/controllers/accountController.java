package com.dmarchante.kiddoh.controllers;

import com.dmarchante.kiddoh.models.Account;
import com.dmarchante.kiddoh.models.AppUser;
import com.dmarchante.kiddoh.repositories.AccountRepo;
import com.dmarchante.kiddoh.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Controller
public class accountController {

    //Auto wire
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    AppUserRepo appUserRepo;
    @GetMapping("/addAccount")
    public String addAccount(Model m){
        //Type of account available
        List<String> accountType = new ArrayList<String>();
        accountType.add("Checking");
        accountType.add("Savings");
        m.addAttribute("accountType",accountType);
        return "addAccount";
    }
    @PostMapping(value="/addAccount")
    public RedirectView addAccount(@RequestParam String name, String type, String balance, Principal p){
        try{
            BigDecimal bal = new BigDecimal(balance);
            Account newAccount = new Account(name,type,bal, appUserRepo.findByUserName(p.getName()));
            accountRepo.save(newAccount);
            return new RedirectView("myAccount");
        }
        catch(Exception ex){
            return new RedirectView("/error");
        }
    }
}
