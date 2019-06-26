package com.dmarchante.kiddoh.models;

import javax.persistence.Entity;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Account {
    /*
        Fields
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
    private String name;
    private BigDecimal balance;
    /*
        Fields: relationship
     */
    //Many account will have one user
    @ManyToOne
    private AppUser user;
    //One account will have many transactions
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactionList;

    /*
       constructors
     */
    //Default Cons
    public Account(){};
    //Param Cons
    public Account(String name,String type,  BigDecimal balance, AppUser user){
        this.setName(name);
        this.setBalance(balance);
        this.setType(type);
        this.setUser(user);
    }
    /*
        Properties: Setters and Getters
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public List<Transaction> getTransactionList() { return this.transactionList; }
    /*
        Methods: APIS
     */
//    public void updateBalance(){
//        updateBalance(this.getBalance());
//    }
    /*
        Methods: Private
     */
    private void updateBalance() {
        for(Transaction transaction: this.transactionList){
            BigDecimal currentBalance = this.getBalance();
            BigDecimal transactionAmount = transaction.getAmount();

            this.setBalance(currentBalance.subtract(transactionAmount));
        }
    }
}
