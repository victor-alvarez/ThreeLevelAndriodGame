package com.example.game;

/**
 * A account
 */
public class Account {

    /**
     * The user id of the Account.
     */
    private String user_id;

    /**
     * Getter for the user id instance variable.
     *
     * @return the user id of the Account.
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * Setter for the user id instance variable.
     *
     * @param user_id the user id of the Account.
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * Constructor for Account class.
     *
     * @param user_id the user id of the Account.
     */
    Account(String user_id) {
        this.user_id = user_id;
    }

}
