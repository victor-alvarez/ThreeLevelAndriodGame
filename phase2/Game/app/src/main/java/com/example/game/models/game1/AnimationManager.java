package com.example.game.models.game1;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * AnimationManager interface.
 */
interface AnimationManager {
    void draw(Canvas canvas, Rect rectangle);

    void playAnim(int state);

    void update();
}
