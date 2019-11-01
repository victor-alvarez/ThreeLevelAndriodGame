package com.example.game.Game3;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * A Object in Game 3.
 */
abstract class Game3Object {
    /**
     * The x position of the Object on the screen.
     */
    private int x;

    /**
     * The y position of the Object on the screen.
     */
    private int y;

    /**
     * Getter for the x position of the Object.
     *
     * @return x : The x position of the Object.
     */
    public int getX() {
        return x;
    }

    /**
     * Setter for the x position of the Object.
     *
     * @param x The x position of the Object.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter for the y position of the Object.
     *
     * @return y : The y position of the Object.
     */
    public int getY() {
        return y;
    }

    /**
     * Setter for the y position of the Object.
     *
     * @param y The y position of the Object.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Abstract method that draws the Object on given canvas.
     *
     * @param canvas The canvas to draw on.
     * @param paint  The paint to use to draw on canvas.
     */
    abstract void draw(Canvas canvas, Paint paint);

    /**
     * Abstract method that updates the Object.
     */
    abstract void update();

}
