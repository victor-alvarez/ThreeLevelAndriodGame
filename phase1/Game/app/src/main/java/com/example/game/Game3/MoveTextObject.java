package com.example.game.Game3;

import android.graphics.Canvas;
import android.graphics.Paint;

public class MoveTextObject extends Game3Object {

    private int textColor;

    private String moveText;

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public String getMoveText() {
        return moveText;
    }

    public void setMoveText(String moveText) {
        this.moveText = moveText;
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
        paint.setColor(getTextColor());
        canvas.drawText(moveText, getX(), getY(), paint);
    }

    @Override
    void update() {

    }

    void update(String displayText, int color) {
        setTextColor(color);
        setMoveText(displayText);

    }

}
