package com.dmarchante.kiddoh.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import java.math.BigDecimal;


/****************
 * Model
 * */
@Entity
public class Transaction {
/****************
 * Instance Variables
 * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String date;
    private Category category;
    private BigDecimal amount;

    @ManyToOne
    Account account;


/****************
 * Constructors
 * */
    public Transaction(String date, BigDecimal amount) {
        this.date = date;
        this.amount = amount;
    }

    public Transaction(String date, Category category, BigDecimal amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public Transaction(String date, Category category, BigDecimal amount, Account account) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.account = account;
    }

/****************
 * Getters / Setters
 * */
    public long getId() { return this.id; }
    public Account getAccount() {return this.account; }
    public String getDate() { return this.date; }
    public Category getCategory() { return this.category; }
    public BigDecimal getAmount() { return this.amount; }

    public void setAccount(Account account) { this.account = account; }
    public void setDate(String date) { this.date = date; }
    public void setCategory(Category category) { this.category = category; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }


/****************
 * Enum
 * */
    public enum Category {
        Toys, VideoGames, Movies, Books, Food, Clothing, Miscellaneous
    }
}




