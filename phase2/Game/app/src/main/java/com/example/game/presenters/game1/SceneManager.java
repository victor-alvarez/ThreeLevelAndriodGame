package com.example.game.presenters.game1;

import android.graphics.Canvas;
import android.view.MotionEvent;

import java.util.ArrayList;

/**
 * SceneManager class. Manages the Scene
 */
public class SceneManager implements Game1Presenter {
    /**
     * Instance variables
     */
    private ArrayList<Scene> scenes = new ArrayList<>();
    private static int ACTIVE_SCENE;

    /**
     * Constructor. Adds GameplayScene to list of scenes. In phase2, more scenes will be added which
     * means ore levels.
     */
    SceneManager() {
        ACTIVE_SCENE = 0;
        SceneFactory sceneFactory = PresenterFactories.SCENE_FACTORY;
        scenes.add(sceneFactory.makeGameplayScene());
    }

    @Override
    public void setDifficulty(String difficulty) {
        for (Scene s : scenes) {
            s.setDifficulty(difficulty);
        }
    }

    /**
     * Handles the events for player interaction with phone screen
     *
     * @param event - event of the interaction with the screen (i.e., touch screen, let go of
     *              screen, etc.)
     */
    @Override
    public void receiveTouch(MotionEvent event) {
        scenes.get(ACTIVE_SCENE).receiveTouch(event);
    }

    /**
     * Update scene
     */
    @Override
    public void update() {
        scenes.get(ACTIVE_SCENE).update();
    }

    /**
     * Draw the screen
     *
     * @param canvas - draw onto Canvas canvas
     */
    @Override
    public void draw(Canvas canvas) {
        scenes.get(ACTIVE_SCENE).draw(canvas);
    }
}
