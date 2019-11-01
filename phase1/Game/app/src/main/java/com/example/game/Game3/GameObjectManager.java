package com.example.game.Game3;

import android.graphics.Color;

import java.util.Map;

/**A Manager class for GameObjects.*/
public class GameObjectManager {

    /**
     * A constructor for GameObjectManager.
     * */
    GameObjectManager(){

    }

    /**
     * Creates a Character for the Player.
     *
     * @return enemy : A CharacterObject for the Player.
     * */
    private CharacterObject createPlayer() {
        CharacterObject player = new CharacterObject();
        return player;
    }

    /**
     * Creates a Health Bar for the Player.
     *
     * @return playerHealth : A HealthBarObject for the Player.
     * */
    private HealthBarObject createPlayerHealthBar() {
        HealthBarObject playerHealth = new HealthBarObject();
        playerHealth.setX(600);
        playerHealth.setY(200);
        playerHealth.setColor(Color.RED);
        playerHealth.setPlayerName("ENEMY");
        playerHealth.setTextSize(50);
        return playerHealth;
    }

    /**
     * Creates a Character for the Enemy.
     *
     * @return enemy : A CharacterObject for the Enemy.
     * */
    private CharacterObject createEnemy() {
        CharacterObject enemy = new CharacterObject();
        return enemy;
    }


    /**
     * Creates a Health Bar for the Enemy.
     *
     * @return enemyHealth : A HealthBarObject for the Enemy.
     * */
    private HealthBarObject createEnemyHealthBar() {
        HealthBarObject playerHealth = new HealthBarObject();
        playerHealth.setX(100);
        playerHealth.setY(200);
        playerHealth.setColor(Color.GREEN);
        playerHealth.setPlayerName("PLAYER");
        playerHealth.setTextSize(50);
        return playerHealth;
    }
}
