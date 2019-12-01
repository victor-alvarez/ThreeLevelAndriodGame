package com.example.game.Game3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

class BottleObject extends Game3Object {

    /**
     * The physical appearance of the Bottle as a Bitmap.
     */
    private Bitmap sprite;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private Boolean active;

    private int updateCount = 50;

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    private int top;
    private int bottom;
    private int left;
    private int right;
    private int moveX = 30;

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


    @Override
    void update() {

    }

    void update(int screenWidth) {
        if (updateCount == 0){
            active = false;
            updateCount = 50;
        }
        if (active) {

            if (getX() >= screenWidth || getX() <= 0) {
                moveX = moveX*-1;
            }
            updateCount -=1;
            setX(getX() + moveX);
            top = getY() ;
            bottom = getY() + getSprite().getHeight() ;
            left = getX() ;
            right = getX() + getSprite().getWidth() ;
        }
    }
}
