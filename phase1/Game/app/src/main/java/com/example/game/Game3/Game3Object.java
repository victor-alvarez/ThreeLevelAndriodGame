package com.example.game.Game3;

import android.graphics.Canvas;

/**A Object in Game 3.*/
public interface Game3Object {
    int x = 0;
    int y = 0;

    void draw(Canvas canvas);
    void update();

}
