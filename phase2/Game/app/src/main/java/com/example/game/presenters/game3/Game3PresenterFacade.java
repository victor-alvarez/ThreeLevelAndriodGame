package com.example.game.presenters.game3;

import android.content.Context;

/**
 * An interface that represents the facade for Game3Presenter.
 */
public interface Game3PresenterFacade {

    /**
     * Creates all the game objects.
     */
    void initializeGameObjects();

    /**
     * Draws all the game objects.
     */
    void draw();

    /**
     * Updates all the game objects.
     */
    void update();

    /**
     * Reads the user touch input.
     *
     * @param touchX The x position the user touched on the screen.
     * @param touchY The y position the user touched on the screen.
     */
    void readTouch(float touchX, float touchY);

    /**
     * Checks the winner of the game.
     *
     * @return The winner of the game.
     */
    String checkWinner();

    /**
     * Gets number of moves to win/lose the game.
     *
     * @return The number of moves to win/lose the game.
     */
    int getNumMoves();

    /**
     * Gets the score of the game.
     *
     * @return The score of the game.
     */
    int getHitPoints();

    /**
     * Gets the wait time to pause the game to allow for animations.
     *
     * @return The wait time to pause the game to allow for animations
     */
    int getWaitTime();

    /**
     * Determines whether it's the player's turn or the enemy's turn.
     *
     * @return Whether it's the player's turn or the enemy's turn.
     */
    boolean getTurn();

    /**
     * Updates the score of the game.
     *
     * @return the score of the game.
     */
    int updateHitpoints();

    /**
     * Determines whether game 3 has ended or not.
     *
     * @return Whether game 3 has ended or not.
     */
    boolean gameEnded(Context context);

    /**
     * Determines whether the whole game is over or not.
     *
     * @return Whether the whole game is over or not.
     */
    boolean gameDone();
}
