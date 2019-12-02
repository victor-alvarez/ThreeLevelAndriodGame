package com.example.game.models.game3;

import java.util.Random;

/**
 * An easy strategy.
 */
class Game3EasyStrategy implements Game3Strategy {

    /**
     * Possible choices of attack higher than the attack the player is capable of.
     */
    private int[] enemyHigherAttack = {13, 13, 13, 13, 14, 14, 15};
    /**
     * Possible choices of attack lower than the attack the player is capable of.
     */
    private int[] enemyLowerAttack = {9, 10, 10, 10, 11, 11, 11, 11, 12};

    /**
     * The enemy's response to a player choosing attack.
     */
    @Override
    public int enemyAttack() {
        int attack = new Random().nextInt(10);
        // 60% chance that higher attack will be picked.
        if (attack <= 5) {
            int damageIndex = new Random().nextInt(enemyHigherAttack.length);
            return enemyHigherAttack[damageIndex];
        } else {
            int damageIndex = new Random().nextInt(enemyLowerAttack.length);
            return enemyLowerAttack[damageIndex];
        }
    }

    /**
     * The enemy's response to a player choosing defend.
     */
    @Override
    public int enemyDefend() {
        // 80% chance that enemy will pick a lower attack.
        int attack = new Random().nextInt(10);
        if (attack <= 1) {
            int damageIndex = new Random().nextInt(enemyHigherAttack.length);
            return enemyHigherAttack[damageIndex];
        } else {
            int damageIndex = new Random().nextInt(enemyLowerAttack.length);
            return enemyLowerAttack[damageIndex];
        }
    }

    /**
     * The player choosing to attack. Also decides whether a health potion should be activated here.
     * Does 12 damage.
     *
     * @param healthPotion A health potion that increases player HP.
     */
    @Override
    public int playerAttack(BottleObject healthPotion) {
        // 1/4 chance that a health potion is activated.
        int randomVar = new Random().nextInt(4);
        if (randomVar == 0) {
            healthPotion.setActive(true);
        }
        return 12;

    }

    /**
     * The player choosing to defend. Does 10 damage.
     */
    @Override
    public int playerDefend() {
        return 10;
    }
}
