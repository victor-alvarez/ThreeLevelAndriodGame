package com.example.game.Game3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

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

    @Override
    void draw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(sprite, getX(), getY(), paint);
    }

    @Override
    void update() {

    }

    void update(int screenWidth) {
        if (getX() >= screenWidth -10){
            setX(getX() - screenWidth/20);
        } else if (getX() <= 10) {
            setX(getX() + screenWidth/20);
        }
    }
}
