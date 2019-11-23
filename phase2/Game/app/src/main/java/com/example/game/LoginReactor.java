package com.example.game;

/**
 * Actions required for a presenter to react effectively to what occurs in the use cases.
 */
interface LoginReactor {
    void incorrectUsername();

    abstract void correctUsername(Account account);
}
