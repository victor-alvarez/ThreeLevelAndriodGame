package com.example.game.Game3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.concurrent.TimeUnit;

/**
 * Game View class for Game 3.
 */
public class Game3View extends SurfaceView implements Runnable {

    /**
     * Checks if the game is still in play.
     */
    private boolean isPlaying = true;

    /**
     * Game thread.
     */
    private Thread thread;

    private Paint paint;

    private GameObjectManager gameObjectManager;

    private Boolean isTurn = true;

    private final Context activityContext;

    /**
     * Game3View constructor.
     *
     * @param context the instance of the class that called created an instance of this class.
     */
    public Game3View(Context context) {
        super(context);
        activityContext = context;
        paint = new Paint();
        gameObjectManager = new GameObjectManager(getResources());
        gameObjectManager.createObjects();
    }

    /**
     * Runs the thread.
     */
    @Override
    public void run() {
        boolean wait;
        while (isPlaying) {
            wait = !gameObjectManager.getTurn();
            update();
            draw();
            if (wait) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gameObjectManager.setTurn(true);
            }
            sleep();
            checkGameEnded();
        }
        ((Game3PlayActivity) activityContext).gameOver(gameObjectManager.checkWinner());
    }

    /**
     * Checks if game is done.
     */
    private void checkGameEnded() {
        if (gameObjectManager.gameEnded()) {
            isPlaying = false;
        }
    }

    /**
     * Updates the game based on the game situation.
     */
    private void update() {
        gameObjectManager.update();
    }

    /**
     * Draws the game objects on the screen.
     */
    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            super.draw(canvas);
            canvas.drawColor(Color.DKGRAY);
            gameObjectManager.draw(canvas, paint);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    /**
     * Pauses the thread for 17 milliseconds (1000 milliseconds / 60) to achieve frame rate of 60
     * FPS.
     */
    private void sleep() {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Resumes the thread.
     */
    void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Pauses the thread.
     */
    void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        gameObjectManager.onTouchEventHelper(event);
        return super.onTouchEvent(event);
    }
}
