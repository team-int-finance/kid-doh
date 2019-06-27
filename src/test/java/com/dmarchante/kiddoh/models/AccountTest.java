package com.dmarchante.kiddoh.models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountTest {

    public void setup(){
        BigDecimal bal = new BigDecimal(500);
        AppUser bob = new AppUser("user", "user");
        Account testAcct = new Account("test", "checking", bal, bob);
    }

    @Test
    public void getType() {
        BigDecimal bal = new BigDecimal(500);
        AppUser bob = new AppUser("user", "user");
        Account testAcct = new Account("test", "checking", bal, bob);
        assertTrue(testAcct.getType().equals("checking"));
    }

    @Test
    public void setType() {
        BigDecimal bal = new BigDecimal(500);
        AppUser bob = new AppUser("user", "user");
        Account testAcct = new Account("test", "checking", bal, bob);
        testAcct.setType("savings");
        assertTrue(testAcct.getType().equals("savings"));
    }

    @Test
    public void getName() {
        BigDecimal bal = new BigDecimal(500);
        AppUser bob = new AppUser("user", "user");
        Account testAcct = new Account("test", "checking", bal, bob);
        assertTrue(testAcct.getName().equals("test"));
    }

    @Test
    public void setName() {
        BigDecimal bal = new BigDecimal(500);
        AppUser bob = new AppUser("user", "user");
        Account testAcct = new Account("test", "checking", bal, bob);
        testAcct.setName("user1");
    }

    @Test
    public void getBalance() {
        BigDecimal bal = new BigDecimal(500);
        AppUser bob = new AppUser("user", "user");
        Account testAcct = new Account("test", "checking", bal, bob);
        assertEquals(testAcct.getBalance().longValue(), (long)500);
    }

    @Test
    public void setBalance() {
        BigDecimal bal = new BigDecimal(500);
        AppUser bob = new AppUser("user", "user");
        Account testAcct = new Account("test", "checking", bal, bob);
        testAcct.setBalance(new BigDecimal(400));
        assertEquals(testAcct.getBalance().longValue(), (long)400);
    }

    @Test
    public void getUser() {
        BigDecimal bal = new BigDecimal(500);
        AppUser bob = new AppUser("user", "user");
        Account testAcct = new Account("test", "checking", bal, bob);
        assertEquals(testAcct.getUser(), bob);
    }

    @Test
    public void setUser() {
        BigDecimal bal = new BigDecimal(500);
        AppUser bob = new AppUser("user", "user");
        AppUser joe = new AppUser("user2", "user2");
        Account testAcct = new Account("test", "checking", bal, bob);
        testAcct.setUser(joe);
        assertEquals(testAcct.getUser(), joe);
    }

}