package com.example.game.models.game1;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

public interface RectPlayer {
    void draw(Canvas canvas);

    void update(Point point);

    Rect getRectangle();
}
