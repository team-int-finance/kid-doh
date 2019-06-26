package com.dmarchante.kiddoh.controllers;

import com.dmarchante.kiddoh.models.Account;
import com.dmarchante.kiddoh.models.AppUser;
import com.dmarchante.kiddoh.models.Transaction;
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
import java.util.EnumSet;
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
    public String addAccount(@RequestParam String name, String type, String balance, Principal p, Model m){

        try{
            BigDecimal bal = new BigDecimal(balance);
            AppUser user = appUserRepo.findByUsername(p.getName());
            Account newAccount = new Account(name,type,bal,user);
            accountRepo.save(newAccount);
            String message = "Successfully added the account: "+ name;
            m.addAttribute("message",message);
            //same lines of code as Transaction Controller;
            List<Account> accounts = user.getMyAccounts();
            List<Enum> categories = new ArrayList<Enum>(EnumSet.allOf(Transaction.Category.class));
            List accountNames = new ArrayList();
            for (Account account : accounts) {
                accountNames.add(account.getName());
            }
            m.addAttribute("principal",p);
            m.addAttribute("accounts", accounts);
            m.addAttribute("categories", categories);
            m.addAttribute("accountNames", accountNames);
            return "accounts";
        }
        catch(Exception ex){
            return "error";
            //return null;
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
        m.addAttribute("principal",p);
         m.addAttribute("editAccount",acc);
        return "editAccount";
    }
    @PostMapping(value = "/account/{id}/edit")
    public String editAccount(@RequestParam Long id, String name, String type,  Principal p, Model m) {
        try {
            Account updatedAcc = accountRepo.findById(id).get();
            updatedAcc.setName(name);
            updatedAcc.setType(type);
            accountRepo.save(updatedAcc);
            String message = "Successfully edited the account: "+ name;
            m.addAttribute("message",message);
            //same lines of code as Transaction Controller;
            AppUser user = appUserRepo.findByUsername(p.getName());
            List<Account> accounts = user.getMyAccounts();
            List<Enum> categories = new ArrayList<Enum>(EnumSet.allOf(Transaction.Category.class));
            List accountNames = new ArrayList();
            for (Account account : accounts) {
                accountNames.add(account.getName());
            }
            m.addAttribute("principal",p);
            m.addAttribute("accounts", accounts);
            m.addAttribute("categories", categories);
            m.addAttribute("accountNames", accountNames);
            return "accounts";
        } catch (Exception ex) {
            return "error";
        }
    }
    @GetMapping("/account/{id}/delete")
    //int temp is dummy variable for over loading
    public String deleteAccount(@PathVariable long id, Model m,Principal p){
        // to display information of selected account to be deleted
        Account acc = accountRepo.findById(id).get();
        m.addAttribute("principal", p);
        m.addAttribute("delAccount",acc);
        return "deleteAccount";
    }
    @PostMapping("/account/{id}/delete")
    public String deleteAccount(@RequestParam long id, Model m, Principal p,Integer temp){
        try{
            // to display information of selected account to be deleted
            Account acc = accountRepo.findById(id).get();
            accountRepo.delete(acc);
            String message = "Successfully deleted the account: "+ acc.getName();
            m.addAttribute("message",message);
            //same lines of code as Transaction Controller;
            AppUser user = appUserRepo.findByUsername(p.getName());
            List<Account> accounts = user.getMyAccounts();
            List<Enum> categories = new ArrayList<Enum>(EnumSet.allOf(Transaction.Category.class));
            List accountNames = new ArrayList();
            for (Account account : accounts) {
                accountNames.add(account.getName());
            }
            m.addAttribute("principal",p);
            m.addAttribute("accounts", accounts);
            m.addAttribute("categories", categories);
            m.addAttribute("accountNames", accountNames);
            return "accounts";
        }
        catch (Exception ex){
            return "error";
        }
    }
}
