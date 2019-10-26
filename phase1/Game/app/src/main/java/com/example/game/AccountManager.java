package com.example.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Account manager that manages accounts.
 */
public class AccountManager implements Serializable {

    /**
     * List of accounts.
     */
    ArrayList<Account> accounts;

    /**
     * Create an account manager
     */
    AccountManager(){
        //TODO: Read data from a file
    }

    /**
     * Get account with name same as user id.
     * @return the account with matching name;
     */
    Account getAccount(String name){
        for (Account account : accounts){
            if (account.getUser_id().equals(name)){
                return account;
            }
        }
        return null;
    }

    /**
     * Adds a new account to the arraylist. Also updates the data file.
     */
     void addAccount(String name){
        accounts.add(new Account(name));
        writeToFile();
    }

    /**
     * Writes data about the accounts to a file
     */
    void writeToFile(){
        return;
    }

    /**
     * Reads data about the accounts to a file.
     */
    private void readFromFile(){
        return;
    }
}
