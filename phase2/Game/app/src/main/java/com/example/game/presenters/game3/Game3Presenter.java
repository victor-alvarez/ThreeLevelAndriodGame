package com.example.game.presenters.game3;

public interface Game3Presenter {

    void initializeGameObjects();

    void draw();

    void update();

    void readTouch(float touchX, float touchY);

    String checkWinner();

    int getNumMoves();

    int getHitPoints();

    int getWaitTime();

    boolean getTurn();

    int updateHitpoints();

    boolean gameEnded();
}
