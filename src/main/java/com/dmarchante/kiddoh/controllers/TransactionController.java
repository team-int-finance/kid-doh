package com.dmarchante.kiddoh.controllers;

import com.dmarchante.kiddoh.models.DataPoint;
import com.dmarchante.kiddoh.models.Account;
import com.dmarchante.kiddoh.models.AppUser;
import com.dmarchante.kiddoh.models.Transaction;
import com.dmarchante.kiddoh.repositories.AccountRepo;
import com.dmarchante.kiddoh.repositories.AppUserRepo;
import com.dmarchante.kiddoh.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
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
        try {
            AppUser user = appUserRepo.findByUsername(p.getName());
            List<Account> accounts = user.getMyAccounts();
            List<Enum> categories = new ArrayList<Enum>(EnumSet.allOf(Transaction.Category.class));
            List accountNames = new ArrayList();

            for (Account account : accounts) {
                accountNames.add(account.getName());
            }

            m.addAttribute("principal", p);
            m.addAttribute("accounts", accounts);
            m.addAttribute("categories", categories);
            m.addAttribute("accountNames", accountNames);

            return "accounts";
        } catch (Exception error) {
            System.out.println("An error has occurred: " + error);
        }

        return null;
    }

    @PostMapping("/myAccounts")
    public RedirectView addTransaction(@RequestParam String date, String transactionCategory, String accountName, String amount) {
        try {
            Account account = accountRepo.findByName(accountName);
            Transaction transaction = new Transaction(date, Transaction.Category.valueOf(transactionCategory), new BigDecimal(amount), account);

            account.updateBalance(transaction);

            transactionRepository.save(transaction);
            accountRepo.save(account);

            return new RedirectView("/myAccounts");

        } catch (Exception error) {

            return new RedirectView("/error");
        }
    }

    @GetMapping("/dashboard")
//    Toys, VideoGames, Movies, Books, Food, Clothing, Miscellaneous, Deposit

    public String getDashboard(Model m, Principal p) throws IOException {
        AppUser user = appUserRepo.findByUsername(p.getName());
        List<Account> accounts = user.getMyAccounts();
        List<Transaction> transactions = accounts.get(0).getTransactionList();
//        List<Transaction> transactionToys = transactionRepository.findAllByCategory();
        Integer toyCount = 0;

        for(Transaction transaction : transactions) {
            if (transaction.getCategory() == Transaction.Category.Toys) {
                toyCount++;
            }
        }

//        Integer toyCount = transactions.size();

        List<DataPoint> dataPoints = new ArrayList<>();

        DataPoint dataPoint = new DataPoint();
        dataPoint.setY(toyCount);
        dataPoint.setLabel("Toys");
        dataPoints.add(dataPoint);

//        dataPoint = new DataPoint();
//        dataPoint.setY(20);
//        dataPoint.setX(2);
//        dataPoints.add(dataPoint);
//
//        dataPoint = new DataPoint();
//        dataPoint.setY(30);
//        dataPoint.setX(3);
//        dataPoints.add(dataPoint);
//
//        dataPoint = new DataPoint();
//        dataPoint.setY(30);
//        dataPoint.setX(4);
//        dataPoints.add(dataPoint);
//
//        dataPoint = new DataPoint();
//        dataPoint.setY(30);
//        dataPoint.setX(5);
//
//        dataPoints.add(dataPoint);
//        dataPoint = new DataPoint();
//        dataPoint.setY(30);
//        dataPoint.setX(6);
//
//        dataPoints.add(dataPoint);
//        dataPoint = new DataPoint();
//        dataPoint.setY(30);
//        dataPoint.setX(7);
//
//        dataPoints.add(dataPoint);
//        dataPoint = new DataPoint();
//        dataPoint.setY(30);
//        dataPoint.setX(8);
//        dataPoints.add(dataPoint);


        m.addAttribute("principal", p);
        m.addAttribute("dataPoints",dataPoints);

        return "dashboard";
    }
}
