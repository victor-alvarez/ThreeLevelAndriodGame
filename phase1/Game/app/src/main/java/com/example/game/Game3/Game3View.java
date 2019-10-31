package com.example.game.Game3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceView;

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
     * Game3View constructor.
     *
     * @param context the instance of the class that called created an instance of this class.
     */
    public Game3View(Context context) {
        super(context);
    }

    /**
     * Runs the thread.
     */
    @Override
    public void run() {
        while (isPlaying) {
            update();
            draw();
            sleep();
            checkGameEnded();
        }
    }

    /**
     * Checks if game is done.
     */
    private void checkGameEnded() {

    }

    /**
     * Updates the game based on the game situation.
     */
    private void update() {

    }

    /**
     * Draws the game objects on the screen.
     */
    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            super.draw(canvas);
            canvas.drawColor(Color.DKGRAY);
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
}
