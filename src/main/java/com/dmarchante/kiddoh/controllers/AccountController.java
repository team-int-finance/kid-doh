package com.dmarchante.kiddoh.controllers;

import com.dmarchante.kiddoh.models.Account;
import com.dmarchante.kiddoh.models.AppUser;
import com.dmarchante.kiddoh.models.Transaction;
import com.dmarchante.kiddoh.repositories.AccountRepo;
import com.dmarchante.kiddoh.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private AppUserRepo appUserRepo;

    @GetMapping("/account/add")
    public String addAccount(Model m, Principal p){
        // Types could be put into enum
        //Type of account available
        List<String> accountType = new ArrayList<>();

        accountType.add("Checking");
        accountType.add("Savings");

        m.addAttribute("principal", p);
        m.addAttribute("accountType", accountType);

        return "addAccount";
    }

    @PostMapping(value="/account/add")
    public String addAccount(@RequestParam String name, String type, String balance, Principal p, Model m){
        try{
            BigDecimal bal = new BigDecimal(balance);
            AppUser user = appUserRepo.findByUsername(p.getName());
            Account newAccount = new Account(name,type,bal,user);
            String message = "Successfully added the account: " + name;

            accountRepo.save(newAccount);

            //same lines of code as Transaction Controller;
            List<Account> accounts = user.getMyAccounts();
            List<Enum> categories = new ArrayList<>(EnumSet.allOf(Transaction.Category.class));
            List<String> accountNames = new ArrayList<>();

            for (Account account : accounts) {
                accountNames.add(account.getName());
            }

            m.addAttribute("message", message);
            m.addAttribute("principal", p);
            m.addAttribute("accounts", accounts);
            m.addAttribute("categories", categories);
            m.addAttribute("accountNames", accountNames);

            return "accounts";
        }
        catch(Exception error){
            return "An error has occurred: " + error;
        }
    }

    @GetMapping("/account/{id}/edit")
    public String editAccount(@PathVariable long id, Model m, Principal p){
        //get the information for the selected account
        List<String> accountType = new ArrayList<>();
        Account account = accountRepo.findById(id).get();

        accountType.add("Checking");
        accountType.add("Savings");

        m.addAttribute("principal", p);
        m.addAttribute("accountType", accountType);
        m.addAttribute("editAccount", account);

        return "editAccount";
    }

    @PostMapping(value = "/account/{id}/edit")
    public String editAccount(@RequestParam Long id, String name, String type,  Principal p, Model m) {
        try {
            Account updatedAcc = accountRepo.findById(id).get();
            String message = "Successfully edited the account: "+ name;

            updatedAcc.setName(name);
            updatedAcc.setType(type);
            accountRepo.save(updatedAcc);

            //same lines of code as Transaction Controller;
            AppUser user = appUserRepo.findByUsername(p.getName());
            List<Account> accounts = user.getMyAccounts();
            List<Enum> categories = new ArrayList<>(EnumSet.allOf(Transaction.Category.class));
            List<String> accountNames = new ArrayList<>();

            for (Account account : accounts) {
                accountNames.add(account.getName());
            }

            m.addAttribute("principal",p);
            m.addAttribute("message",message);
            m.addAttribute("accounts", accounts);
            m.addAttribute("categories", categories);
            m.addAttribute("accountNames", accountNames);

            return "accounts";
        } catch (Exception error) {
            return "An error has occurred: " + error;
        }
    }

    @GetMapping("/account/{id}/delete")
    //int temp is dummy variable for over loading
    public String deleteAccount(@PathVariable long id, Model m,Principal p){
        // to display information of selected account to be deleted
        Account account = accountRepo.findById(id).get();

        m.addAttribute("principal", p);
        m.addAttribute("delAccount", account);

        return "deleteAccount";
    }

    @PostMapping("/account/{id}/delete")
    public String deleteAccount(@RequestParam long id, Model m, Principal p,Integer temp){
        try{
            // to display information of selected account to be deleted
            Account acc = accountRepo.findById(id).get();
            String message = "Successfully deleted the account: "+ acc.getName();
            AppUser user = appUserRepo.findByUsername(p.getName());

            accountRepo.delete(acc);

            //same lines of code as Transaction Controller;
            List<Account> accounts = user.getMyAccounts();
            List<Enum> categories = new ArrayList<>(EnumSet.allOf(Transaction.Category.class));
            List<String> accountNames = new ArrayList<>();
            for (Account account : accounts) {
                accountNames.add(account.getName());
            }

            m.addAttribute("principal",p);
            m.addAttribute("message",message);
            m.addAttribute("accounts", accounts);
            m.addAttribute("categories", categories);
            m.addAttribute("accountNames", accountNames);

            return "accounts";
        } catch (Exception error){
            return "An error has occurred: " + error;
        }
    }
}
