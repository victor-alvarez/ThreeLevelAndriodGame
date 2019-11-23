package com.example.game;

/**
 * List of methods/capabilities of a login method.
 */
interface LoginActions {
    void incorrectUsername();

    abstract void moveToMainMenu(Account account);
}
