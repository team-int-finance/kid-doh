package com.dmarchante.kiddoh.controllers;

import com.dmarchante.kiddoh.models.Account;
import com.dmarchante.kiddoh.models.AppUser;
import com.dmarchante.kiddoh.repositories.AccountRepo;
import com.dmarchante.kiddoh.repositories.AppUserRepo;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Controller
public class AccountController {
    //Auto wire
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    AppUserRepo appUserRepo;

    @GetMapping("/account/add")
    public String addAccount(Model m, Principal p){
        //Type of account available
        List<String> accountType = new ArrayList<String>();
        accountType.add("Checking");
        accountType.add("Savings");
        m.addAttribute("principal", p);
        m.addAttribute("accountType",accountType);
        return "addAccount";
    }
     @PostMapping(value="/account/add")
    public RedirectView addAccount(@RequestParam String name, String type, String balance, Principal p){
        try{
            BigDecimal bal = new BigDecimal(balance);
            AppUser user = appUserRepo.findByUsername(p.getName());
            Account newAccount = new Account(name,type,bal,user);
            accountRepo.save(newAccount);
            return new RedirectView("myAccount");
        }
        catch(Exception ex){
            return new RedirectView("/error");
        }
    }
    @GetMapping("/account/{id}/edit")
    public String editAccount(@PathVariable long id, Model m, Principal p){
        //get the information for the selected account
        List<String> accountType = new ArrayList<String>();
        accountType.add("Checking");
        accountType.add("Savings");
        m.addAttribute("accountType",accountType);
        // to display information of selected account
        Account acc = accountRepo.findById(id).get();
         m.addAttribute("editAccount",acc);
        return "editAccount";
    }
    @PostMapping(value = "/account/{id}/edit")
    public RedirectView editAccount(@RequestParam Long id, String name, String type, String balance, Principal p) {
        try {
            BigDecimal bal = new BigDecimal(balance);
            Account updatedAcc = accountRepo.findById(id).get();
            updatedAcc.setName(name);
            updatedAcc.setType(type);
            updatedAcc.setBalance(bal);
            accountRepo.save(updatedAcc);
            return new RedirectView("myAccount");
        } catch (Exception ex) {
            return new RedirectView("/error");
        }
    }
    @GetMapping("/account/{id}/delete")
    public String deleteAccount(@PathVariable long id, Model m){
        // to display information of selected account to be deleted
        Account acc = accountRepo.findById(id).get();
        m.addAttribute("delAccount",acc);
        return "deleteAccount";
    }
    @PostMapping("/account/{id}/delete")
    public RedirectView deleteAccount(@RequestParam long id){
        try{
            // to display information of selected account to be deleted
            Account acc = accountRepo.findById(id).get();
            accountRepo.delete(acc);
            return new RedirectView("/myAccount");

        }
        catch (Exception ex){
            return new RedirectView("/error");
        }
    }
}
