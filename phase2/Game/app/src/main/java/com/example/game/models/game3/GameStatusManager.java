package com.example.game.models.game3;

import android.content.Context;
import android.content.res.Resources;

import com.example.game.R;

import static com.example.game.BaseActivity.account;

public class GameStatusManager {


    private final Resources res;
    private final GameObjectManager gameObjectManager;

    public GameStatusManager(Resources res, GameObjectManager gameObjectManager) {
        this.res = res;
        this.gameObjectManager = gameObjectManager;
    }

    /**
     * Checks if the game has ended (when either of the Player's health has reached 0.
     */
    public boolean gameEnded(int hitPoints, Context context) {
        boolean status = (gameObjectManager.getEnemyHealth().getHealthLevel() == 0 ||
                gameObjectManager.getPlayerHealth().getHealthLevel() == 0);

        if (status) {
            account.incrementLevel(context.getApplicationContext().getFilesDir());
            account.incrementScore(hitPoints, context.getApplicationContext().getFilesDir());
            account.decrementHitPoints(100 - hitPoints, context.getApplicationContext().getFilesDir());
            account.incrementGamesPlayed(context.getApplicationContext().getFilesDir());
        }

        return status;
    }

    public boolean gameDone() {
        return account.getHitPoints() <= 0;
    }

    /**
     * Check's which one of the CharacterObjects is the winner (The enemy or the Player) and return
     * string that displays the result of the game. Also updates the hitpoints for the player.
     *
     * @return result : The result of the game.
     */
    public String checkWinner() {
        if (gameObjectManager.getPlayerHealth().getHealthLevel() == 0) {
            return res.getString(R.string.lost);
        } else {
            return res.getString(R.string.win);
        }
    }
}
