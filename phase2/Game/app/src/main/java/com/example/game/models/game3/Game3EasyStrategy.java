package com.example.game.models.game3;

import java.util.Random;

class Game3EasyStrategy implements Game3Strategy {

    private int[] enemyHigherAttack = {13, 13, 13, 13, 14, 14, 15};
    private int[] enemyLowerAttack = {9, 10, 10, 10, 11, 11, 11, 11, 12};


    @Override
    public int enemyAttack() {
        int attack = new Random().nextInt(10);
        // 70% chance that higher attack will be picked.
        if (attack <= 6){
            int damageIndex = new Random().nextInt(enemyHigherAttack.length);
            return enemyHigherAttack[damageIndex];
        } else {
            int damageIndex = new Random().nextInt(enemyLowerAttack.length);
            return enemyLowerAttack[damageIndex];
        }
    }

    @Override
    public int enemyDefend() {

        int attack = new Random().nextInt(5);
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
        int randomVar = new Random().nextInt(3);
        if (randomVar == 0){
            healthPotion.setActive(true);
        }
        return 12;

    }

    @Override
    public int playerDefend() {
        return 10;
    }
}
