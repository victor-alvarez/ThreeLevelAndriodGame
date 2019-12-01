package com.example.game.models.game3;

import java.util.Random;

class Game3HardStrategy implements Game3Strategy {
    private int[] enemyHigherAttack = {9, 9, 9, 9, 10, 10, 12};
    private int[] enemyLowerAttack = {4, 5, 5, 5, 6, 6, 7, 7};

    @Override
    public int enemyAttack() {

        // 90% chance that a higher attack will be picked.
        int attack = new Random().nextInt(10);
        if (attack <= 9){
            int damageIndex = new Random().nextInt(enemyHigherAttack.length);
            return enemyHigherAttack[damageIndex];
        } else {
            int damageIndex = new Random().nextInt(enemyLowerAttack.length);
            return enemyLowerAttack[damageIndex];
        }
    }

    @Override
    public int enemyDefend() {

        int attack = new Random().nextInt(3);
        if (attack == 0){
            int damageIndex = new Random().nextInt(enemyHigherAttack.length);
            return enemyHigherAttack[damageIndex];
        } else {
            int damageIndex = new Random().nextInt(enemyLowerAttack.length);
            return enemyLowerAttack[damageIndex];
        }
    }

    @Override
    public int playerAttack(BottleObject healthPotion) {
        int randomVar = new Random().nextInt(6);
        if (randomVar == 0){
            healthPotion.setActive(true);
        }
        return 8;

    }

    @Override
    public int playerDefend() {
        return 6;
    }
}
