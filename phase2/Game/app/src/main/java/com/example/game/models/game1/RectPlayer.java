package com.example.game.models.game1;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * RectPlayer interface.
 */
public interface RectPlayer {
    void draw(Canvas canvas); // draws on canvas

    void update(Point point); // updates through game loop

    Rect getRectangle(); // returns rectangle
}
