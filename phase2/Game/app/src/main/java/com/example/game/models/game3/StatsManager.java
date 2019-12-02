package com.example.game.models.game3;

/**
 * A class that manages the statistics for the game.
 */
public class StatsManager {

    /**
     * The score of the game.
     */
    private int hitPoints;

    /**
     * Getter for the score of the game.
     *
     * @return hitPoints : The score of the game.
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Setter for the score of the game.
     *
     * @param  hitPoints : The score of the game.
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * The number of moves the player took to win/lose.
     */
    private int numMoves;

    /**
     * Getter for the number of moves.
     *
     * @return numMoves : The number of moves the player took to win/lose.
     */
    public int getNumMoves() {
        return numMoves;
    }

    /**
     * Setter for the number of moves.
     *
     * @param  numMoves : The number of moves the player took to win/lose.
     */
    public void setNumMoves(int numMoves) {
        this.numMoves = numMoves;
    }

}
