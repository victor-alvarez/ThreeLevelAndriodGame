package com.example.game.models.interfaces;

/**
 * Interface for reactions to the results of the Use Cases.
 */
public interface CreateAccountListener {
    void accountCreationFailed();

    void accountCreationSuccess();
}
