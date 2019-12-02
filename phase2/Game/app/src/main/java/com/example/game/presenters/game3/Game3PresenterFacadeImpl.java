package com.example.game.presenters.game3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.game.models.game3.DrawObjects;
import com.example.game.models.game3.GameObjectManager;
import com.example.game.models.game3.GameStatusManager;
import com.example.game.models.game3.StatsManager;
import com.example.game.models.game3.UpdateManager;

/**
 * A Facade class for Game3Presenter.
 */
public class Game3PresenterFacadeImpl implements Game3PresenterFacade {

    /**
     * A class that manages all the game objects.
     */
    private final GameObjectManager gameObjectManager;

    /**
     * A class that manages all the updates of the game objects.
     */
    private final UpdateManager updateManager;

    /**
     * A class that draws all the game objects.
     */
    private final DrawObjects drawObjects;

    /**
     * A class that manages all the statistics of the game objects.
     */
    private final StatsManager statsManager;

    /**
     * A class that manages the status of the game (Win/Lose).
     */
    private final GameStatusManager gameStatusManager;

    /**
     * A class that manages the drawing of all the game objects.
     */
    private DrawManager drawManager;

    /**
     * Canvas to draw the game objects on.
     */
    private Canvas canvas;

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
        drawManager.setCanvas(this.canvas);
    }

    /**
     * Constructor.
     *
     * @param res        Additional resources for the game.
     * @param difficulty The difficulty level of the game.
     * @param canvas     The canvas for the game.
     * @param paint      The paint for the game.
     */
    protected Game3PresenterFacadeImpl(Resources res, String difficulty, Canvas canvas, Paint paint) {
        this.canvas = canvas;
        drawManager = new DrawManager(this.canvas, paint);
        gameObjectManager = new GameObjectManager(res);
        this.statsManager = new StatsManager();
        this.updateManager = new UpdateManager(this.gameObjectManager, res, difficulty, this.statsManager);
        this.drawObjects = new DrawObjects(this.gameObjectManager, this.drawManager);
        this.gameStatusManager = new GameStatusManager(res, this.gameObjectManager);
    }

    /**
     * Creates all the game objects.
     */
    @Override
    public void initializeGameObjects() {
        gameObjectManager.createObjects();
    }

    /**
     * Draws all the game objects.
     */
    @Override
    public void draw() {
        drawObjects.draw();
    }

    /**
     * Updates all the game objects.
     */
    @Override
    public void update() {
        updateManager.update();
    }

    /**
     * Reads the user touch input.
     *
     * @param touchX The x position the user touched on the screen.
     * @param touchY The y position the user touched on the screen.
     */
    @Override
    public void readTouch(float touchX, float touchY) {
        updateManager.onTouchEventHelper(touchX, touchY);
    }

    /**
     * Checks the winner of the game.
     *
     * @return The winner of the game.
     */
    @Override
    public String checkWinner() {
        return gameStatusManager.checkWinner();
    }

    /**
     * Gets number of moves to win/lose the game.
     *
     * @return The number of moves to win/lose the game.
     */
    @Override
    public int getNumMoves() {
        return statsManager.getNumMoves();
    }

    /**
     * Gets the score of the game.
     *
     * @return The score of the game.
     */
    @Override
    public int getHitPoints() {
        return statsManager.getHitPoints();
    }

    /**
     * Gets the wait time to pause the game to allow for animations.
     *
     * @return The wait time to pause the game to allow for animations
     */
    @Override
    public int getWaitTime() {
        return updateManager.getWaitTime();
    }

    /**
     * Determines whether it's the player's turn or the enemy's turn.
     *
     * @return Whether it's the player's turn or the enemy's turn.
     */
    @Override
    public boolean getTurn() {
        return updateManager.getTurn();
    }

    /**
     * Updates the score of the game.
     *
     * @return the score of the game.
     */
    @Override
    public int updateHitpoints() {
        return updateManager.updateHitpoints();
    }

    /**
     * Determines whether game 3 has ended or not.
     *
     * @return Whether game 3 has ended or not.
     */
    @Override
    public boolean gameEnded(Context context) {
        return gameStatusManager.gameEnded(updateHitpoints(), context);
    }

    /**
     * Determines whether the whole game is over or not.
     *
     * @return Whether the whole game is over or not.
     */
    @Override
    public boolean gameDone() {
        return gameStatusManager.gameDone();
    }
}
