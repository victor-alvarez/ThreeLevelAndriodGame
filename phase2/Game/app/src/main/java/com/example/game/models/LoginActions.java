package com.example.game.models;

/**
 * List of methods/capabilities of a login method
 */
public interface LoginActions {
    void incorrectUsername();

    abstract void moveToMainMenu(AccountHolder accountHolder);
}
