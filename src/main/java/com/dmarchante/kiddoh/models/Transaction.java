package com.dmarchante.kiddoh.models;

@Entity
public class Transaction {
    /****************
     * Instance Variables
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


/****************
 * Constructors
 * */


/****************
 * Getters / Setters
 * */
    public long getId() {
        return id;
    }


/****************
 * Instance Methods
 * */
}
