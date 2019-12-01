package com.example.game.models.game1.scenes;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Scene interface.
 */
public interface Scene {
    void update(); // Update scene

    void draw(Canvas canvas); // Draw onto Canvas canvas

    void receiveTouch(MotionEvent event); // Handle player interactions with screen

    void setDifficulty(String difficulty); // Sets the difficulty of the scene.
}
