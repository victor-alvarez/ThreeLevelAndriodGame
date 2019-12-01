package com.example.game.presenters.game3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class DrawManager {

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    private Canvas canvas;

    private Paint paint;

    DrawManager(Canvas canvas, Paint paint) {
        this.canvas = canvas;
        this.paint = paint;
    }

    public void drawCharacterObject(Bitmap sprite, int x, int y) {
        canvas.drawBitmap(sprite, x, y, paint);
    }


    public void drawHealthBarObject(int healthLevel, int color, int textSize, String playerName, int x, int y) {
        paint.setColor(color);
        paint.setTextSize(textSize);
        canvas.drawText(playerName.toUpperCase() + healthLevel, x, y, paint);
    }

    public void drawButtonObject(int btnColor, int textColor, Rect button, String btnName, int x, int y) {
        paint.setColor(btnColor);
        canvas.drawRect(button, paint);
        paint.setColor(textColor);
        canvas.drawText(btnName, x, y, paint);
    }

    public void drawMoveTextObject(int textColor, String moveText, int x, int y) {
        paint.setColor(textColor);
        canvas.drawText(moveText, x, y, paint);
    }

    public void drawBottleObject(Bitmap sprite, int x, int y) {
        canvas.drawBitmap(sprite, x, y, paint);
    }
}
