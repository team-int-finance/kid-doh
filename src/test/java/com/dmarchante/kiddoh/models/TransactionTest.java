package com.dmarchante.kiddoh.models;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TransactionTest {
    private BigDecimal bal = new BigDecimal(500);
    private BigDecimal trans = new BigDecimal(100);
    private BigDecimal deposit = new BigDecimal(500);
    private AppUser bob = new AppUser("user", "user");
    private Account testAcct = new Account("test", "checking", bal, bob);
    private Transaction testTrans = new Transaction("01/01/2001",
            Transaction.Category.Toys,
            trans,
            testAcct);
    private Transaction transDeposit = new Transaction("01/01/2001",
            Transaction.Category.Deposit,
            deposit,
            testAcct);

    @Test
    public void getAccount() {
        assertEquals(testTrans.getAccount(), testAcct);
    }

    @Test
    public void getDate() {
        assertTrue(testTrans.getDate().equals("01/01/2001"));
    }

    @Test
    public void getCategory() {
        assertEquals(testTrans.getCategory(), Transaction.Category.Toys);
    }

    @Test
    public void getAmount() {
        assertEquals(testTrans.getAmount().longValue(), trans.longValue());

    }

    @Test
    public void setDate() {
        testTrans.setDate("02/02/2002");
        assertTrue(testTrans.getDate().equals("02/02/2002"));
    }

    @Test
    public void setCategory() {
        testTrans.setCategory(Transaction.Category.Books);
        assertEquals(testTrans.getCategory(), Transaction.Category.Books);
    }

    @Test
    public void setAmount() {
        testTrans.setAmount(new BigDecimal(1000));
        assertNotEquals(testTrans.getAmount(), trans);
    }
}