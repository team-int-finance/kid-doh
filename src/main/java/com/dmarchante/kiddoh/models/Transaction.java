package com.dmarchante.kiddoh.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.util.Currency;

@Entity
public class Transaction {
/****************
 * Instance Variables
 * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Currency amount;
    private String date;

    @ManyToOne//(mappedBy = "name")
    Account account;


/****************
 * Constructors
 * */


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
