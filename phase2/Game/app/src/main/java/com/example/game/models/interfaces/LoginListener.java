package com.example.game.models.interfaces;

import com.example.game.models.AccountHolder;

/**
 * Actions required for a login presenter to react effectively to what occurs in the use cases
 */
public interface LoginListener {
    void incorrectUsername();

    abstract void correctUsername(AccountHolder accountHolder);
}
