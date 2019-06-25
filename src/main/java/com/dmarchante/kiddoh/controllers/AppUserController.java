package com.dmarchante.kiddoh.controllers;

import com.dmarchante.kiddoh.models.AppUser;
import com.dmarchante.kiddoh.repositories.AccountRepo;
import com.dmarchante.kiddoh.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.PersistenceException;
import java.security.Principal;

@Controller
public class AppUserController {

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public RedirectView createUser(String username, String password, Principal p, Model m){
        AppUser newUser = new AppUser(username, bCryptPasswordEncoder.encode(password));
        try {
            appUserRepo.save(newUser);
            m.addAttribute("principal", p);
            return new RedirectView("/");

        } catch(DataIntegrityViolationException e) {
            return new RedirectView("/signup?error=uniqueUserName");
        }
    }

}
