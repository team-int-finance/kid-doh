package com.dmarchante.kiddoh;

import com.dmarchante.kiddoh.models.Account;
import com.dmarchante.kiddoh.models.AppUser;
import com.dmarchante.kiddoh.models.Transaction;
import com.dmarchante.kiddoh.repositories.AccountRepo;
import com.dmarchante.kiddoh.repositories.AppUserRepo;
import com.dmarchante.kiddoh.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;

import static com.dmarchante.kiddoh.models.Transaction.Category.*;

@EnableAutoConfiguration
@SpringBootApplication
public class KidDohApplication {
    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(KidDohApplication.class, args);
    }

    @EventListener
    public void seedDB(ContextRefreshedEvent event) {
        seedTables();
    }

    private void seedTables() {
        AppUser lotty = new AppUser("admin", bCryptPasswordEncoder.encode("1234"));
        appUserRepo.save(lotty);

        Account lottyChecking = new Account("Lotty's spending account!!!!", "Checking", new BigDecimal(100.00), lotty);
        Account lottySavings = new Account("Lotty's no touchy account!!!!", "Checking", new BigDecimal(500.00), lotty);
        accountRepo.save(lottyChecking);
        accountRepo.save(lottySavings);

        Transaction lottyBoughtToy = new Transaction("1/1/1901", Toys, new BigDecimal(8), lottyChecking);
        Transaction lottyBoughtVideoGame = new Transaction("1/1/1901", VideoGames, new BigDecimal(8), lottyChecking);
        Transaction lottyBoughtMovie = new Transaction("1/1/1901", Movies, new BigDecimal(8), lottyChecking);
        Transaction lottyBoughtBook = new Transaction("1/1/1901", Books, new BigDecimal(8), lottyChecking);
        Transaction lottyBoughtFood = new Transaction("1/1/1901", Food, new BigDecimal(8), lottyChecking);
        transactionRepository.save(lottyBoughtToy);
        transactionRepository.save(lottyBoughtVideoGame);
        transactionRepository.save(lottyBoughtMovie);
        transactionRepository.save(lottyBoughtBook);
        transactionRepository.save(lottyBoughtFood);

    }
}
