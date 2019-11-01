package com.example.game.Game3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class CharacterObject extends Game3Object {

    private Bitmap sprite;

    public Bitmap getSprite() {
        return sprite;
    }

    public void setSprite(Bitmap sprite) {
        this.sprite = sprite;
    }

    CharacterObject() {

    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawBitmap(sprite, getX(), getY(), paint);
    }

    @Override
    public void update() {

    }
}
