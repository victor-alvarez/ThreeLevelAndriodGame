package com.example.game.models;

/**
 * Interface which contains all the actions which the create account functionality should be able
 * to perform.
 */
public interface CreateAccountActions {
    void accountCreationFailed();

    void accountCreationSuccess();
}