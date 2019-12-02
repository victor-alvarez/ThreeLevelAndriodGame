package com.example.game.models.game3;

import java.util.Random;

class Game3NormalStrategy implements Game3Strategy {
    /**
     * Possible choices of attack higher than the attack the player is capable of.
     */
    private int[] enemyHigherAttack = {11, 11, 11, 12, 12, 13, 13, 15};
    /**
     * Possible choices of attack lower than the attack the player is capable of.
     */
    private int[] enemyLowerAttack = {6, 7, 7, 7, 8, 8, 9, 9};

    /**
     * The enemy's response to a player choosing attack.
     */
    @Override
    public int enemyAttack() {
        // 80% chance that higher attack will be picked.
        int attack = new Random().nextInt(10);
        if (attack <= 7) {
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

        int attack = new Random().nextInt(4);
        if (attack == 0) {
            int damageIndex = new Random().nextInt(enemyHigherAttack.length);
            return enemyHigherAttack[damageIndex];
        } else {
            int damageIndex = new Random().nextInt(enemyLowerAttack.length);
            return enemyLowerAttack[damageIndex];
        }
    }

    /**
     * The player choosing attack. Also decides whether a health potion should be activated here.
     *
     * @param healthPotion A health potion that increases player HP.
     */
    @Override
    public int playerAttack(BottleObject healthPotion) {
        int randomVar = new Random().nextInt(4);
        if (randomVar == 0) {
            healthPotion.setActive(true);
        }
        return 10;

    }

    /**
     * The player choosing to defend.
     */
    @Override
    public int playerDefend() {
        return 8;
    }
}
