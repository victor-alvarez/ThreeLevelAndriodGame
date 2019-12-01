package com.example.game.models;

/**
 * The reactions the listener to the use cases can take.
 */
public interface LoadGameListener {
    void directToGame1();

    void directToGame2();

    void directToGame3();

    void directToAfterGame1();

    void directToAfterGame3();
}
