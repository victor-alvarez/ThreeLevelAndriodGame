package com.example.game.Game3;

import android.content.Context;
import android.view.SurfaceView;

public class Game3View extends SurfaceView implements Runnable {

    private boolean isPlaying = true;
    private Thread thread;

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

    }

    /**
     * Pauses the thread for 17 milliseconds (1000 milliseconds / 60) to achieve frame rate of 60
     * FPS.
     */
    private void sleep() {

    }
}
