package com.example.game.models.Interfaces;

import com.example.game.models.AccountHolder;

/**
 * List of methods/capabilities of a login class
 */
public interface LoginActions {
    void incorrectUsername();

    abstract void moveToMainMenu(AccountHolder accountHolder);
}
