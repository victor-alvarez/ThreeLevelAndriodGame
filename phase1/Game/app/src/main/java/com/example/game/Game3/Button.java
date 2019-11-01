package com.example.game.Game3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Button extends Game3Object {

    private Rect button;

    private boolean active = true;

    private int btnColor;

    private int textColor;

    private String btnName;

    public String getBtnName() {
        return btnName;
    }

    public void setBtnName(String btnName) {
        this.btnName = btnName;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }


    public int getBtnColor() {
        return btnColor;
    }

    public void setBtnColor(int color) {
        this.btnColor = color;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Rect getButton() {
        return button;
    }

    public void setButton(Rect button) {
        this.button = button;
    }

    @Override
    void draw(Canvas canvas, Paint paint) {
        if (active) {
            paint.setColor(btnColor);
            canvas.drawRect(button, paint);
            paint.setColor(textColor);
            canvas.drawText(btnName, getX(), getY(), paint);
        }
    }

    @Override
    void update() {

    }
}
