package com.example.game.models;

/**
 * Interface for reactions to the results of the Use Cases.
 */
public interface CreateAccountListener {
    void accountCreationFailed();

    void accountCreationSuccess();
}
