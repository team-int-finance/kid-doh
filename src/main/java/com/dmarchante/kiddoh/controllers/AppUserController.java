package com.dmarchante.kiddoh.controllers;

import com.dmarchante.kiddoh.models.AppUser;
import com.dmarchante.kiddoh.repositories.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;

@Controller
public class AppUserController {

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public RedirectView createUser(String username, String password, Principal p, Model m){
        AppUser newUser = new AppUser(username, bCryptPasswordEncoder.encode(password));
        try {
            appUserRepo.save(newUser);

            Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            m.addAttribute("principal", p);

            return new RedirectView("/");
        } catch(DataIntegrityViolationException e) {
            return new RedirectView("/signup?error=uniqueUserName");
        }
    }
}
