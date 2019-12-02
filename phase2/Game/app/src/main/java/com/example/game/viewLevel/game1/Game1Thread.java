package com.example.game.viewLevel.game1;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * MainThread class. Runs game loop under fps.
 */
class Game1Thread extends Thread implements MainThread {
    /**
     * Instance Variables
     */
    private static final int MAX_FPS = 30;
    private final SurfaceHolder surfaceHolder;
    private Game1View game1View;
    private boolean running;
    public static Canvas canvas;

    /**
     * Constructor
     *
     * @param surfaceHolder - sets the surface holder
     * @param game1View     - sets the game panel
     */
    Game1Thread(SurfaceHolder surfaceHolder, Game1View game1View) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.game1View = game1View;
    }

    /**
     * @param running - sets running to be t/f
     */
    @Override
    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        long startTime;
        long timeMillis;
        long waitTime;
        int frameCount = 0;
        long totalTime = 0;
        long targetTime = 1000 / MAX_FPS;

        while (running) {
            startTime = System.nanoTime();
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.game1View.update();
                    this.game1View.draw(canvas);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - timeMillis;
            try {
                if (waitTime > 0) {
                    sleep(waitTime);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if (frameCount == MAX_FPS) {
                double averageFPS = 1000 / ((totalTime / frameCount) / 1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(averageFPS);
            }
        }
    }
}
