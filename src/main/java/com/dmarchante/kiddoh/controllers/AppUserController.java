package com.dmarchante.kiddoh.controllers;

import com.dmarchante.kiddoh.models.AppUser;
import com.dmarchante.kiddoh.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

public class AppUserController {

    @Autowired
    AppUserRepo appUserRepo;

//    @Autowired
//    something for user accounts

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/createUser")
    public RedirectView createUser(String userName, String password){
        AppUser newUser = new AppUser(userName, bCryptPasswordEncoder.encode(password));
        appUserRepo.save(newUser);
        return new RedirectView("/");
    }
}
