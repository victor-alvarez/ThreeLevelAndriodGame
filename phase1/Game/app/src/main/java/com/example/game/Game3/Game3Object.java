package com.example.game.Game3;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * A Object in Game 3.
 */
abstract class Game3Object {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    abstract void draw(Canvas canvas, Paint paint);

    abstract void update();

}
