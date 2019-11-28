package com.example.game;

import android.content.Context;

import java.io.Serializable;

public class GameData implements Serializable {
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
    private int coins;

    GameData(){
        lastAttemptedLevel = 0;
        hitPoints = 100;
        currentScore = 0;
        gamesPlayed = 0;
        coins = 0;
    }

    public int getLastAttemptedLevel() {
        return lastAttemptedLevel;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getCoins() {
        return coins;
    }

    /**
     * Increments level or resets it where appropriate and records it
     */
    public void incrementLevel() {
        if (lastAttemptedLevel < 4){
            lastAttemptedLevel += 1;
        } else {
            lastAttemptedLevel = 0;
        }
    }

    /**
     * Decrements level for purposes of retrying where appropriate and records it
     */
    public void decrementLevel() {
        if (lastAttemptedLevel > 0){
            lastAttemptedLevel -= 1;
        }
    }

    /**
     * Reduces hitpoints by a set amount and records it
     * @param reduce the amount by which hit points are reduced
     */
    public void decrementHitPoints(int reduce) {
        hitPoints -= reduce;
    }

    /**
     * Changes score by amount add
     * @param add the amount to be added to the score
     */
    public void incrementScore(int add) {
        currentScore += add;
    }

    /**
     * Increments the number of times the games are played on this account
     */
    public void incrementGamesPlayed() {
        gamesPlayed += 1;
    }

    /**
     * Increments the number of times the games are played on this account
     */
    public void incrementCoins(int loot) {
        coins += loot;
    }

    /**
     * Sets this account's stats to starting ones
     */
    public void resetData(){
        lastAttemptedLevel = 0;
        hitPoints = 100;
        currentScore = 0;
        gamesPlayed = 0;
    }
}
