package com.example.game.models.game3;

/**
 * An interface that represents the game logic.
 */
interface Game3Strategy {

    /**
     * The enemy's response to a player choosing attack.
     */
    int enemyAttack();

    /**
     * The enemy's response to a player choosing defend.
     */
    int enemyDefend();

    /**
     * The player choosing attack. Also decides whether a health potion should be activated here.
     *
     * @param healthPotion A health potion that increases player HP.
     */
    int playerAttack(BottleObject healthPotion);

    /**
     * The player choosing to defend.
     */
    int playerDefend();
}
