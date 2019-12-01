package com.example.game.presenters.game3;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.game.models.game3.GameObjectManager;

public class Game3PresenterImp implements Game3Presenter {


    private final GameObjectManager gameObjectManager;

    private DrawManager drawManager;

    private Canvas canvas;

    protected Game3PresenterImp(Resources res, String difficulty, Canvas canvas, Paint paint){
        this.canvas = canvas;
        drawManager = new DrawManager(this.canvas, paint);
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

    public void setCanvas(Canvas canvas){
        this.canvas = canvas;
        drawManager.setCanvas(this.canvas);
    }
}
