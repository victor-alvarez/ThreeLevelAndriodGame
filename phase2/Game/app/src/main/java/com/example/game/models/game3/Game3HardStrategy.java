package com.example.game.models.game3;

import java.util.Random;

/**
 * An hard strategy.
 */
class Game3HardStrategy implements Game3Strategy {
    /**
     * Possible choices of attack higher than the attack the player is capable of.
     */
    private int[] enemyHigherAttack = {9, 9, 9, 9, 10, 10, 12};
    /**
     * Possible choices of attack lower than the attack the player is capable of.
     */
    private int[] enemyLowerAttack = {4, 5, 5, 5, 6, 6, 7, 7};

    /**
     * The enemy's response to a player choosing attack.
     */
    @Override
    public int enemyAttack() {

        // 70% chance that a higher attack will be picked.
        int attack = new Random().nextInt(10);
        if (attack <= 6) {
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
        // 70% chance that enemy will a lower attack.
        int attack = new Random().nextInt(10);
        if (attack <= 2) {
            int damageIndex = new Random().nextInt(enemyHigherAttack.length);
            return enemyHigherAttack[damageIndex];
        } else {
            int damageIndex = new Random().nextInt(enemyLowerAttack.length);
            return enemyLowerAttack[damageIndex];
        }
    }

    /**
     * The player choosing attack. Also decides whether a health potion should be activated here.
     * Player does 8 damage.
     *
     * @param healthPotion A health potion that increases player HP.
     */
    @Override
    public int playerAttack(BottleObject healthPotion) {
        // 1/6 chance of a health potion appearing.
        int randomVar = new Random().nextInt(6);
        if (randomVar == 0) {
            healthPotion.setActive(true);
        }
        return 8;

    }

    /**
     * The player choosing to defend. Player does 6 damage
     */
    @Override
    public int playerDefend() {
        return 6;
    }
}
