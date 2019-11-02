package com.example.game.Game3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * A class for Button Object in GameView.
 */
public class Button extends Game3Object {

    /**
     * The physical representation of the Button as a rectangle object
     */
    private Rect button;

    /**
     * Boolean that decides if the Button is active or not.
     */
    private boolean active = true;

    /**
     * The color of the Button.
     */
    private int btnColor;

    /**
     * The color of the Button label
     */
    private int textColor;

    /**
     * The label for the Button
     */
    private String btnName;

    /**
     * A getter for Button Name.
     *
     * @return btnName : The Button Name.
     */
    String getBtnName() {
        return btnName;
    }

    /**
     * Setter for Button Name.
     *
     * @param btnName The Button Name.
     */
    void setBtnName(String btnName) {
        this.btnName = btnName;
    }

    /**
     * Getter for the TextColor.
     *
     * @return textColor : The color of the Button Label.
     */
    int getTextColor() {
        return textColor;
    }

    /**
     * Setter for TextColor
     *
     * @param textColor : The color of the Button Label.
     */
    void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    /**
     * Getter for Button Color.
     *
     * @return btnColor : the color of the Button.
     */
    int getBtnColor() {
        return btnColor;
    }

    /**
     * Setter for Button Color.
     *
     * @param color The color of the Button.
     */
    void setBtnColor(int color) {
        this.btnColor = color;
    }

    /**
     * Getter for Button active.
     *
     * @return active : Checks if Button is active.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Setter for Button active.
     *
     * @param active Sets the button active or not.
     */
    void setActive(boolean active) {
        this.active = active;
    }


    /**
     * Getter for physical representation of the Button.
     *
     * @return button : The physical representation of the Button.
     */
    Rect getButton() {
        return button;
    }

    /**
     * Setter for the physical representation of the Button.
     *
     * @param button The physical representation of the Button.
     */
    void setButton(Rect button) {
        this.button = button;
    }

    /**
     * Draws the Button on a canvas.
     *
     * @param canvas The canvas to draw on.
     * @param paint  The paint to use to draw on canvas.
     */
    @Override
    void draw(Canvas canvas, Paint paint) {
        if (active) {
            paint.setColor(btnColor);
            canvas.drawRect(button, paint);
            paint.setColor(textColor);
            canvas.drawText(btnName, getX(), getY(), paint);
        }
    }

    /**
     * Overrides update for the Button from GabeObject class.
     */
    @Override
    void update() {

    }
}
