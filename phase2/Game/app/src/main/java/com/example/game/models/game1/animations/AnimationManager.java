package com.example.game.models.game1.animations;

import android.graphics.Canvas;
import android.graphics.Rect;

public interface AnimationManager {
    void draw(Canvas canvas, Rect rectangle);

    void playAnim(int state);

    void update();
}
