package com.example.game.models;

/**
 * List of methods/capabilities of a login class
 */
public interface LoginActions {
    void incorrectUsername();

    abstract void moveToMainMenu(AccountHolder accountHolder);
}
