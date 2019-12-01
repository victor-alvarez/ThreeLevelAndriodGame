package com.example.game.models.game3;

import java.util.Random;

class Game3NormalStrategy implements Game3Strategy {
    private int[] enemyHigherAttack = {11, 11, 11, 12, 12, 13, 13, 15};
    private int[] enemyLowerAttack = {6, 7, 7, 7, 8, 8, 9, 9};


    @Override
    public int enemyAttack() {
        // 80% chance that higher attack will be picked.
        int attack = new Random().nextInt(10);
        if (attack <= 7){
            int damageIndex = new Random().nextInt(enemyHigherAttack.length);
            return enemyHigherAttack[damageIndex];
        } else {
            int damageIndex = new Random().nextInt(enemyLowerAttack.length);
            return enemyLowerAttack[damageIndex];
        }
    }

    @Override
    public int enemyDefend() {

        int attack = new Random().nextInt(4);
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
        int randomVar = new Random().nextInt(4);
        if (randomVar == 0){
            healthPotion.setActive(true);
        }
        return 10;

    }

    @Override
    public int playerDefend() {
        return 8;
    }
}
