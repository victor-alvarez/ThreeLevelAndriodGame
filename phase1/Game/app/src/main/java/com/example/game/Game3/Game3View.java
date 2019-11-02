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

    /**
     * The paint used on the canvas.
     */
    private Paint paint;


    /**
     * Instance that manages all the objects in the Game.
     */
    private GameObjectManager gameObjectManager;

    /**
     * The instance of the class that called created an instance of this class.
     */
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

        //Creates all the game objects that are needed for this Game.
        gameObjectManager.createObjects();
    }

    /**
     * Runs the thread.
     */
    @Override
    public void run() {
        boolean wait;
        while (isPlaying) {

            //Checks if Game has ended. If it has, it breaks from the Game Loop.
            if (checkGameEnded()) {
                break;
            }

            //Checks if the
            wait = !gameObjectManager.getTurn();

            //Updates the game objects.
            update();

            //Draws the game objects
            draw();

            //Gives the user 1 second to see how much HP damage they did to the Enemy.
            if (wait) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gameObjectManager.setTurn(true);
            }

            //Thread pauses to get a Frame Rate.
            sleep();
        }

        //Ends the game and given method takes User to Game 3 Exit Activity.
        ((Game3PlayActivity) activityContext).gameOver(gameObjectManager.checkWinner(),
                gameObjectManager.updateHitpoints(), gameObjectManager.getNumMoves());
    }

    /**
     * Checks if game is done.
     */
    private boolean checkGameEnded() {
        return gameObjectManager.gameEnded();
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
        //Checks of the surface is valid to draw on.
        if (getHolder().getSurface().isValid()) {

            //Locks the canvas, sets Grey Background, then draw objects (handled by
            // gameObjectManager.draw) and then unlocks the canvas.
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

    /**
     * Reads user's touch input and gameObjectManager handles the cases.
     *
     * @param event The user's movement.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gameObjectManager.onTouchEventHelper(event);
        return super.onTouchEvent(event);
    }
}
