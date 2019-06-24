package com.dmarchante.kiddoh.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.util.Currency;


/****************
 * Enum Class
 * */
enum Category {
    Charity, Saving, Housing, Utilities, Food, Clothing, Transportation, Medical, Health, Insurance, Personal, Recreation, Debts;
}


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
    private Category category,
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
//    public long getId() {
//        return id;
//    }


/****************
 * Instance Methods
 * */
}
