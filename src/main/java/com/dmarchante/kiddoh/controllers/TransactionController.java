package com.dmarchante.kiddoh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {

    @GetMapping("/accounts")
    public String getAccounts() { return "accounts"; }

}
