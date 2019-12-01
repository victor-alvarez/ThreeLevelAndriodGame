package com.example.game.models;

/**
 * The game statistic data for an account.
 */
class GameData {
    /** Account's save data:
     * at index 0 - last level attempted (0-4):
     * 0 - have not started level 1 yet,
     * 1, 2, 3 - started level 1, 2, 3,
     * 4 - won the last game;
     * at index 1 - hit points (0-100);
     * at index 2 - current score (0+);
     * at index 3 - games played (addiction counter) (0+). Includes retries of games.*/
    private int lastAttemptedLevel;
    private int hitPoints;
    private int currentScore;
    private int gamesPlayed;

    GameData(){
        lastAttemptedLevel = 0;
        hitPoints = 100;
        currentScore = 0;
        gamesPlayed = 0;
    }

    /**
     * @return the last attempted level.
     */
    int getLastAttemptedLevel() {
        return lastAttemptedLevel;
    }

    /**
     * @return the hit points.
     */
    int getHitPoints() {
        return hitPoints;
    }

    /**
     * @return the current score.
     */
    int getCurrentScore() {
        return currentScore;
    }

    /**
     * @return the number of games played.
     */
    int getGamesPlayed() {
        return gamesPlayed;
    }


    /**
     * Increments level or resets it where appropriate and records it
     */
    void incrementLevel() {
        if (lastAttemptedLevel < 4){
            lastAttemptedLevel += 1;
        } else {
            lastAttemptedLevel = 0;
        }
    }

    /**
     * Decrements level for purposes of retrying where appropriate and records it
     */
    void decrementLevel() {
        if (lastAttemptedLevel > 0){
            lastAttemptedLevel -= 1;
        }
    }

    /**
     * Reduces hitpoints by a set amount and records it
     * @param reduce the amount by which hit points are reduced
     */
    void decrementHitPoints(int reduce) {
        hitPoints -= reduce;
    }

    /**
     * Changes score by amount add
     * @param add the amount to be added to the score
     */
    void incrementScore(int add) {
        currentScore += add;
    }

    /**
     * Increments the number of times the games are played on this account
     */
    void incrementGamesPlayed() {
        gamesPlayed += 1;
    }

    /**
     * Sets this account's stats to starting ones
     */
    void resetData(){
        lastAttemptedLevel = 0;
        hitPoints = 100;
        currentScore = 0;
    }
}
