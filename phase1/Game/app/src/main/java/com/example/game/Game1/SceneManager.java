package com.example.game.Game1;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * SceneManager class. Manages the Scene
 */
public class SceneManager {
    /**
     * Instance variables
     */
    private ArrayList<Scene> scenes = new ArrayList<>();
    static int ACTIVE_SCENE;

    /**
     * Constructor. Adds GameplayScene to list of scenes. In phase2, more scenes will be added which
     * means ore levels.
     */
    SceneManager() {
         ACTIVE_SCENE = 0;
         scenes.add(new GameplayScene());
    }

    /**
     * Handles the events for player interaction with phone screen
     * @param event - event of the interaction with the screen (i.e., touch screen, let go of
     *                 screen, etc.)
     */
    void receiveTouch(MotionEvent event) {
        scenes.get(ACTIVE_SCENE).receiveTouch(event);
    }

    /**
     * Update scene
     */
    public void update() {
        scenes.get(ACTIVE_SCENE).update();
    }

    /**
     * Draw the screen
     * @param canvas - draw onto Canvas canvas
     */
    public void draw(Canvas canvas) {
        scenes.get(ACTIVE_SCENE).draw(canvas);
    }
}
