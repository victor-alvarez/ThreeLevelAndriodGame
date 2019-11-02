package com.example.game.Game1;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Scene interface.
 */
public interface Scene {
    void update();
    void draw(Canvas canvas);
    void receiveTouch(MotionEvent event);
}
