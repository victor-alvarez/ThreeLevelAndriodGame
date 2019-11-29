package com.example.game.models;

import com.example.game.Account;
import com.example.game.AccountHolder;

/**
 * Actions required for a presenter to react effectively to what occurs in the use cases.
 */
public interface LoginListener {
    void incorrectUsername();

    abstract void correctUsername(AccountHolder accountHolder);
}
