package com.dmarchante.kiddoh.models;

import javax.persistence.Entity;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import static com.dmarchante.kiddoh.models.Transaction.Category.Deposit;

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
    public void updateBalance(Transaction transaction) {
        BigDecimal transactionAmount = transaction.getAmount();

        if (transaction.getCategory() == (Enum) Deposit) {
            this.setBalance(this.getBalance().add(transactionAmount));
        } else {
            this.setBalance(this.getBalance().subtract(transactionAmount));
        }
    }
}
