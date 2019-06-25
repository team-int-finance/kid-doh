package com.dmarchante.kiddoh.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.util.Currency;


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
    private Currency amount;

    @ManyToOne
    Account account;


/****************
 * Constructors
 * */
    public Transaction(String date, Currency amount) {
        this.date = date;
        this.amount = amount;
    }

    public Transaction(String date, Category category, Currency amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }


/****************
 * Getters / Setters
 * */
    public long getId() { return this.id; }
    public Account getAccount() {return this.account; }
    public String getDate() { return this.date; }
    public Category getCategory() { return this.category; }
    public Currency getAmount() { return this.amount; }

    public void setAccount(Account account) { this.account = account; }
    public void setDate(String date) { this.date = date; }
    public void setCategory(Category category) { this.category = category; }
    public void setAmount(Currency amount) { this.amount = amount; }
}


/****************
 * Enum Class
 * */
enum Category {
    Toys, VideoGames, Movies, Books, Food, Clothing, Miscellaneous
}
