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

    }

    @Override
    void update() {

    }
    
}
