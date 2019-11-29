package com.example.game.Game3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Character Object class. Subclass of abstract class Game3Object.
 */
class CharacterObject extends Game3Object {

    /**
     * The physical appearance of the Character as a Bitmap.
     */
    private Bitmap sprite ;

    private Bitmap[] spriteAnimate = new Bitmap[4];

    private int frameTime = 200;

    void setSpriteAnimate(Bitmap[] spriteAnimate) {
        this.spriteAnimate = spriteAnimate;
    }

    private int spriteFrame = 0;

    /**
     * Getter for the Character sprite.
     *
     * @return sprite : The physical appearance of the Character.
     */
    Bitmap getSprite() {
        return sprite;
    }

    /**
     * Setter for the Character sprite.
     *
     * @param sprite The physical appearance of the Character.
     */
    void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }

    /**
     * Draws the Character on a canvas.
     *
     * @param canvas The canvas to draw on.
     * @param paint  The paint to use to draw on canvas.
     */
    @Override
    void draw(Canvas canvas, Paint paint) {

        canvas.drawBitmap(spriteAnimate[spriteFrame], getX(), getY(), paint);
    }

    /**
     * Overrides update for the CharacterObject from GabeObject class.
     */
    @Override
    void update() {
        if (spriteFrame == 4){
            spriteFrame = 0;
        } else {
            spriteFrame++;
        }
        sprite = spriteAnimate[spriteFrame];
    }
}
