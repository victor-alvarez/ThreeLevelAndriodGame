package com.example.game.models;

/**
 * Actions required for a presenter to react effectively to what occurs in the use cases
 */
public interface LoginListener {
    void incorrectUsername();

    abstract void correctUsername(AccountHolder accountHolder);
}
