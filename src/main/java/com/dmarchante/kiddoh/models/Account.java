package com.dmarchante.kiddoh.models;



import javax.persistence.Entity;
import javax.persistence.*;

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
    private float balance;
    /*
        Fields: relationship
     */
    //Many account will have one user
    @ManyToOne
    private AppUser user;
    //One account will have many transactions
    //@OneToMany(mappedBy = "")
    //private List<Transcation> transcationList;
    /*
       constructors
     */
    //Default Cons
    public Account(){};
    //Param Cons
    public Account(String name,String type, float balance, AppUser User){
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

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}
