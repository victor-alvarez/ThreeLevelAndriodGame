package com.example.game.presenters.game3;

import android.content.res.Resources;

import com.example.game.models.game3.GameObjectManager;
import com.example.game.views.game3.DrawManager;
import com.example.game.views.game3.Game3View;

public class Game3PresenterImp implements Game3Presenter {


    private final GameObjectManager gameObjectManager;

    protected Game3PresenterImp(Resources res, DrawManager drawManager, String difficulty){
        gameObjectManager = new GameObjectManager(res, drawManager, difficulty);
    }

    @Override
    public void initializeGameObjects() {
        gameObjectManager.createObjects();
    }

    @Override
    public void draw() {
        gameObjectManager.draw();
    }

    @Override
    public void update() {
        gameObjectManager.update();
    }

    @Override
    public void readTouch(float touchX, float touchY) {
        gameObjectManager.onTouchEventHelper(touchX, touchY);
    }

    @Override
    public String checkWinner() {
        return gameObjectManager.checkWinner();
    }

    @Override
    public int getNumMoves() {
        return gameObjectManager.getNumMoves();
    }

    @Override
    public int getHitPoints() {
        return gameObjectManager.getHitpoints();
    }

    @Override
    public int getWaitTime() {
        return gameObjectManager.getWaitTime();
    }

    @Override
    public boolean getTurn() {
        return gameObjectManager.getTurn();
    }

    @Override
    public int updateHitpoints() {
        return gameObjectManager.updateHitpoints();
    }

    @Override
    public boolean gameEnded() {
        return gameObjectManager.gameEnded();
    }
}
