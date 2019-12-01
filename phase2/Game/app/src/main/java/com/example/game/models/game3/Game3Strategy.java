package com.example.game.models.game3;

interface Game3Strategy {

    int enemyAttack();

    int enemyDefend();

    int playerAttack(BottleObject healthPotion);

    int playerDefend();
}
