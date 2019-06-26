package com.dmarchante.kiddoh.controllers;

import com.dmarchante.kiddoh.models.Account;
import com.dmarchante.kiddoh.models.AppUser;
import com.dmarchante.kiddoh.models.Transaction;
import com.dmarchante.kiddoh.repositories.AccountRepo;
import com.dmarchante.kiddoh.repositories.AppUserRepo;
import com.dmarchante.kiddoh.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/myAccounts")
    public String getAccounts(Principal p, Model m) {
        AppUser user = appUserRepo.findByUsername(p.getName());
        List<Account> accounts = user.getMyAccounts();
        List<Enum> categories = new ArrayList<Enum>(EnumSet.allOf(Transaction.Category.class));
        List accountNames = new ArrayList();

        for (Account account : accounts) {
            accountNames.add(account.getName());
        }

        m.addAttribute("accounts", accounts);
        m.addAttribute("categories", categories);
        m.addAttribute("accountNames", accountNames);

        return "accounts";
    }

    @PostMapping("/myAccounts")
    public RedirectView addTransaction(Principal p, String date, String category, String amount) {


        return new RedirectView("/myAccounts");
    }
}
