package com.example.game.viewLevel.game1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.game.models.game1.Constants;
import com.example.game.presenters.game1.ScenePresenterImp;
import com.example.game.presenters.game1.MainThread;

/**
 * GamePanel class.
 */
public class Game1View extends SurfaceView implements SurfaceHolder.Callback {

    /**
     * Instance variables
     */
    private MainThread thread;
    private ScenePresenterImp manager;

    /**
     * Constructor
     *
     * @param context - the context
     */
    public Game1View(Context context) {
        super(context);
        getHolder().addCallback(this);
        Constants.CURRENT_CONTEXT = context;
        thread = new MainThread(getHolder(), this);
        manager = new ScenePresenterImp();
        setFocusable(true);
    }

    public void setDifficulty(String difficulty) {
        manager.setDifficulty(difficulty);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);
        Constants.INIT_TIME = System.currentTimeMillis();
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        manager.receiveTouch(event);
        return true;
        // return super.onTouchEvent(event);
    }

    /**
     * updates manager
     */
    public void update() {
        manager.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        manager.draw(canvas);
    }
}
