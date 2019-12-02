package com.example.game.models.game3;

import android.content.Context;
import android.content.res.Resources;

import com.example.game.R;

import static com.example.game.BaseActivity.account;

/**
 * Class that manages the status of the game.
 */
public class GameStatusManager {

    /**
     * Additional resources needed for the game.
     */
    private final Resources res;

    private boolean won;

    /**
     * Class that manages the game objects.
     */
    private final GameObjectManager gameObjectManager;

    /**
     * Constructor.
     *
     * @param res               Additional resources needed for the game.
     * @param gameObjectManager Class that manages the game objects.
     */
    public GameStatusManager(Resources res, GameObjectManager gameObjectManager) {
        this.res = res;
        this.gameObjectManager = gameObjectManager;
    }

    /**
     * Checks if the game has ended.
     *
     * @param hitPoints The score of the game.
     * @param context   The context of the game, needed for accessing additional files.
     */
    public boolean gameEnded(int hitPoints, Context context) {
        boolean status = (gameObjectManager.getEnemyHealth().getHealthLevel() == 0 ||
                gameObjectManager.getPlayerHealth().getHealthLevel() == 0);

        if (status) {
            account.incrementLevel(context.getApplicationContext().getFilesDir());
            account.incrementScore(hitPoints, context.getApplicationContext().getFilesDir());
            if (won) {
                account.decrementHitPoints(0,
                        context.getApplicationContext().getFilesDir());
            } else {
                account.decrementHitPoints(10, context.getApplicationContext().getFilesDir());
            }
            account.incrementGamesPlayed(context.getApplicationContext().getFilesDir());
        }

        return status;
    }

    /**
     * Check's which one of the CharacterObjects is the winner (The enemy or the Player) and return
     * string that displays the result of the game. Also updates the hitpoints for the player.
     *
     * @return result : The result of the game.
     */
    public String checkWinner() {
        if (gameObjectManager.getPlayerHealth().getHealthLevel() == 0) {
            won = false;
            return res.getString(R.string.lost);
        } else {
            won = true;
            return res.getString(R.string.win);
        }
    }
}
