package com.dmarchante.kiddoh.models;

import javax.persistence.*;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(unique = true)
    String userName;

    String password;

    @OneToMany(mappedBy = user)
    List<Account> myAccounts;

    public AppUser(){}

    public AppUser(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
