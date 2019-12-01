package com.example.game.Game3;

public interface Game3Strategy {

    int enemyAttack();

    int enemyDefend();

    int playerAttack(BottleObject healthPotion);

    int playerDefend();
}
