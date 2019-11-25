package com.example.game.domain;

import com.example.game.Account;

/**
 * List of methods/capabilities of a login method.
 */
public interface LoginActions {
    void incorrectUsername();

    abstract void moveToMainMenu(Account account);
}
