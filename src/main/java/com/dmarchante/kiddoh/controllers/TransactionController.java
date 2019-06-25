package com.dmarchante.kiddoh.controllers;

import com.dmarchante.kiddoh.models.Account;
import com.dmarchante.kiddoh.repositories.AccountRepo;
import com.dmarchante.kiddoh.repositories.AppUserRepo;
import com.dmarchante.kiddoh.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/myAccount")
    public String getAccounts() {
//        List<Account> accounts = (List<Account>) accountRepo.findAll();
//
//        m.addAttribute("userAccounts", accounts);

        return "accounts";
    }



}
