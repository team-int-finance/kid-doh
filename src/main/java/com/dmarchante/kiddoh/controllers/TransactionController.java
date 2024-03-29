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
    private AppUserRepo appUserRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/myAccounts")
    public String getAccounts(Principal p, Model m) {
        try {
            AppUser user = appUserRepo.findByUsername(p.getName());
            List<Account> accounts = user.getMyAccounts();
            List<Enum> categories = new ArrayList<>(EnumSet.allOf(Transaction.Category.class));
            List<String> accountNames = new ArrayList<>();

            for (Account account : accounts) {
                accountNames.add(account.getName());
            }

            m.addAttribute("principal",p);
            m.addAttribute("accounts", accounts);
            m.addAttribute("categories", categories);
            m.addAttribute("accountNames", accountNames);

            return "accounts";
        } catch (Exception error) {
            return "An error has occurred: " + error;
        }
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
    public String getDashboard(Model m, Principal p) throws IOException {
        try {
            AppUser user = appUserRepo.findByUsername(p.getName());
            if(user.getMyAccounts().size() > 0){
                List<Account> accounts = user.getMyAccounts();
                List<DataPoint> dataPoints = new ArrayList<>();
                List<Transaction> transactions = accounts.get(0).getTransactionList();

                dataPoints.add(chartData(transactions, Transaction.Category.Toys, "Toys"));
                dataPoints.add(chartData(transactions, Transaction.Category.VideoGames, "Video Games"));
                dataPoints.add(chartData(transactions, Transaction.Category.Movies, "Movies"));
                dataPoints.add(chartData(transactions, Transaction.Category.Books, "Books"));
                dataPoints.add(chartData(transactions, Transaction.Category.Food, "Food"));
                dataPoints.add(chartData(transactions, Transaction.Category.Clothing, "Clothing"));
                dataPoints.add(chartData(transactions, Transaction.Category.Miscellaneous, "Miscellaneous"));
                dataPoints.add(chartData(transactions, Transaction.Category.Deposit, "Deposit"));

                m.addAttribute("principal", p);
                m.addAttribute("dataPoints",dataPoints);
                m.addAttribute("appUser",user);
            }
            else{
                m.addAttribute("principal", p);
                m.addAttribute("appUser",null);
            }

            return "dashboard";
        } catch (Exception error) {
            return "An error has occurred: " + error;
        }
    }

    private DataPoint chartData(List<Transaction> transactions, Enum category, String categoryString) {
        BigDecimal count = new BigDecimal(0  );
        DataPoint dataPoint = new DataPoint();

        for(Transaction transaction : transactions) {
            if (transaction.getCategory() == category) {
                count = count.add(transaction.getAmount());
            }
        }

        dataPoint.setY(count);
        dataPoint.setLabel(categoryString);

        return dataPoint;
    }
}
