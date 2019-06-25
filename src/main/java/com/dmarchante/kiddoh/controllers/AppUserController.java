package com.dmarchante.kiddoh.controllers;

import com.dmarchante.kiddoh.models.AppUser;
import com.dmarchante.kiddoh.repositories.AccountRepo;
import com.dmarchante.kiddoh.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.PersistenceException;

@Controller
public class AppUserController {

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/createUser")
    public RedirectView createUser(String userName, String password){
        AppUser newUser = new AppUser(userName, bCryptPasswordEncoder.encode(password));
        try {
            appUserRepo.save(newUser);
            return new RedirectView("/");

        } catch(DataIntegrityViolationException e) {
            return new RedirectView("/?error=uniqueUserName");
        }
    }

}
