package com.example.game;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Account manager that manages accounts.
 */
public class AccountManager implements Serializable {

    /** Creates new account with given login. Activates from Create Account button. Takes login
     * from Enter Login field. Uses default values for customization settings and save data.
     * Creates save file if missing.
     *
     * @param login of the Account.
     * @return new Account with given login.
     */

    public static Account createNewAccount (String login) {
        try {
            File saveFile = new File("gameSaveFile.txt");
            if (!saveFile.exists()) {
                saveFile.createNewFile();
                FileWriter saveAccount = new FileWriter(saveFile);
                saveAccount.write("*Empty, 0, Empty 0, Empty, 0");
                saveAccount.close();
            }
            FileWriter saveAccount = new FileWriter(saveFile, true);
            saveAccount.write("\n" + login + ", 0, 0, 0, 0, 0, 0, 0");
            saveAccount.close();
            }
        catch (IOException error) {
            System.out.println("ERROR");
        }
        return new Account(login);
    }

    /** Creates account that was earlier saved to file. Activates from Select Account button.
     * Takes login from Enter Login field. Uses saved values for customization settings and
     * save data.
     *
     * @param login of the Account.
     * @return Array[boolean][Account]: account found => true + loaded Account, save file or
     * account missing => false + null.
     */

    public static Object[] openExistingAccount (String login) {
        try {
            File saveFile = new File("gameSaveFile.txt");
            if (!saveFile.exists()) {
                Object[] result = {false, null};
                return result;
            }
            FileReader loadAccountData = new FileReader(saveFile);
            BufferedReader loadAccData = new BufferedReader(loadAccountData);
            String line = loadAccData.readLine();
            while ((line = loadAccData.readLine()) != null) {
                int i = line.indexOf(", ");
                String s = line.substring(0, i);
                if (login.equals(s)) {
                    String[] l = line.split(", ");
                    String[] cust = {l[1], l[2], l[3]};
                    String[] save = {l[4], l[5], l[6], l[7]};
                    Account acc = new Account(login, cust, save);
                    Object[] result = {true, acc};
                    return result;
                }
            }
        }
        catch (IOException error) {
            System.out.println("Can't find account");
        }
        Object[] result = {false, null};
        return result;
    }

    /**
     * List of accounts.
     *//*
    ArrayList<Account> accounts;

    *//**
     * Create an account manager
     *//*
    AccountManager(){
        //TODO: Read data from a file
    }

    *//**
     * Get account with name same as user id.
     * @return the account with matching name;
     *//*
    Account getAccount(String name){
        for (Account account : accounts){
            if (account.getUser_id().equals(name)){
                return account;
            }
        }
        return null;
    }

    *//**
     * Adds a new account to the arraylist. Also updates the data file.
     *//*
     void addAccount(String name){
        accounts.add(new Account(name));
        writeToFile();
    }

    *//**
     * Writes data about the accounts to a file
     *//*
    void writeToFile(){
        return;
    }

    *//**
     * Reads data about the accounts to a file.
     *//*
    private void readFromFile(){
        return;
    }*/
}
