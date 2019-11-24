package com.example.game.Domain;

import com.example.game.Account;

/**
 * Actions required for a presenter to react effectively to what occurs in the use cases.
 */
public interface LoginReactor {
    void incorrectUsername();

    abstract void correctUsername(Account account);
}
