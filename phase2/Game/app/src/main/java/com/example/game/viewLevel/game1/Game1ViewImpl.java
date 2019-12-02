package com.example.game.viewLevel.game1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.game.models.game1.Constants;
import com.example.game.presenters.game1.PresenterFactories;
import com.example.game.presenters.game1.ScenePresenter;
import com.example.game.presenters.game1.ScenePresenterFactory;

/**
 * GamePanel class.
 */
public class Game1ViewImpl extends SurfaceView implements SurfaceHolder.Callback, Game1View {

    /**
     * Instance variables
     */
    private MainThread thread;
    private ScenePresenter scenePresenter;
    MainThreadFactory mainThreadFactory;

    /**
     * Constructor
     *
     * @param context - the context
     */
    public Game1ViewImpl(Context context) {
        super(context);
        getHolder().addCallback(this);
        Constants.CURRENT_CONTEXT = context;
        mainThreadFactory = ViewFactories.MAIN_THREAD_FACTORY;
        thread = mainThreadFactory.makeGame1Thread(getHolder(), this);
        ScenePresenterFactory scenePresenterFactory = PresenterFactories.SCENE_PRESENTER_FACTORY;
        scenePresenter = scenePresenterFactory.makeScenePresenterImp();
        setFocusable(true);
    }

    @Override
    public void setDifficulty(String difficulty) {
        scenePresenter.setDifficulty(difficulty);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = mainThreadFactory.makeGame1Thread(getHolder(), this);
        Constants.INIT_TIME = System.currentTimeMillis();
        thread.setRunning(true);
        ((Thread) thread).start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while (retry) {
            try {
                thread.setRunning(false);
                ((Thread) thread).join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scenePresenter.receiveTouch(event);
        return true;
        // return super.onTouchEvent(event);
    }

    /**
     * updates manager
     */
    public void update() {
        scenePresenter.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        scenePresenter.draw(canvas);
    }
}
