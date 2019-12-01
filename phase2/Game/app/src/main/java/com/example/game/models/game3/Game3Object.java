package com.example.game.models.game3;

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
    int getX() {
        return x;
    }

    /**
     * Setter for the x position of the Object.
     *
     * @param x The x position of the Object.
     */
    void setX(int x) {
        this.x = x;
    }

    /**
     * Getter for the y position of the Object.
     *
     * @return y : The y position of the Object.
     */
    int getY() {
        return y;
    }

    /**
     * Setter for the y position of the Object.
     *
     * @param y The y position of the Object.
     */
    void setY(int y) {
        this.y = y;
    }

    /**
     * Abstract method that updates the Object.
     */
    abstract void update();

}
