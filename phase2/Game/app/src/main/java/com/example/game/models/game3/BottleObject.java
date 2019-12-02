package com.example.game.models.game3;

import android.graphics.Bitmap;

/**
 * A class for a Bottle.
 */
class BottleObject extends Game3Object {

    /**
     * The physical appearance of the Bottle as a Bitmap.
     */
    private Bitmap sprite;

    /**
     * Getter for the Bottle sprite.
     *
     * @return sprite : The physical appearance of the Bottle.
     */
    Bitmap getSprite() {
        return sprite;
    }

    /**
     * Setter for the Bottle sprite.
     *
     * @param sprite The physical appearance of the Bottle.
     */
    void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }

    /**
     * Determines if the Bottle should be displayed on the screen or not.
     */
    private Boolean active;

    /**
     * Getter for active.
     *
     * @return active : Determines if the Bottle should be displayed on the screen or not.
     */
    Boolean getActive() {
        return active;
    }

    /**
     * Setter for active.
     *
     * @param active Determines if the Bottle should be displayed on the screen or not.
     */
    void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * The y position of the top of the sprite.
     */
    private int top;

    /**
     * Getter for top.
     *
     * @return active : The y position of the top of the sprite.
     */
    int getTop() {
        return top;
    }

    /**
     * The y position of the bottom of the sprite.
     */
    private int bottom;

    /**
     * Getter for bottom.
     *
     * @return active : The y position of the bottom of the sprite.
     */
    int getBottom() {
        return bottom;
    }

    /**
     * The x position of the left of the sprite.
     */
    private int left;

    /**
     * Getter for left.
     *
     * @return active : The x position of the left of the sprite.
     */
    int getLeft() {
        return left;
    }

    /**
     * The x position of the right of the sprite.
     */
    private int right;

    /**
     * Getter for right.
     *
     * @return active : The x position of the right of the sprite.
     */
    int getRight() {
        return right;
    }

    /**
     * How much the sprite moves every time the screen is updated.
     */
    private int moveX = 30;

    /**
     * How many times update is called before the sprite becomes inactive.
     */
    private int updateCount = 25;

    /**
     * Overrides update for the ButtonObject from GameObject class.
     */
    @Override
    void update() {

    }

    /**
     * Moves the sprite.
     *
     * @param screenWidth The width of the screen.
     */
    void update(int screenWidth) {
        // Checks if sprite has been on the screen long enough. If it has, it becomes inactive.
        if (updateCount == 0) {
            active = false;
            updateCount = 50;
        }

        //Moves the sprite 30 pixels the right/left.
        if (active) {

            if (getX() >= screenWidth || getX() <= 0) {
                moveX = moveX * -1;
            }
            updateCount -= 1;
            setX(getX() + moveX);
            top = getY();
            bottom = getY() + getSprite().getHeight();
            left = getX();
            right = getX() + getSprite().getWidth();
        }
    }
}
