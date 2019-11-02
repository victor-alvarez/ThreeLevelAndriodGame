package com.example.game.Game3;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * A Move Text Game 3 Object class that displays the Move a Character makes
 */
public class MoveTextObject extends Game3Object {

    /**
     * The color of the Text to display.
     */
    private int textColor;

    /**
     * The Text to display.
     */
    private String moveText;

    /**
     * Getter for the the color of the Text to display.
     *
     * @return textColor : The color of the Text to display.
     */
    public int getTextColor() {
        return textColor;
    }

    /**
     * Setter for the the color of the Text to display.
     *
     * @param textColor The color of the Text to display.
     */
    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    /**
     * Getter for the Text to display.
     *
     * @return moveText : The Text to display.
     */
    public String getMoveText() {
        return moveText;
    }

    /**
     * Setter for the Text to display.
     *
     * @param moveText : The Text to display.
     */
    public void setMoveText(String moveText) {
        this.moveText = moveText;
    }

    /**
     * Overridden method that draws the Text on given canvas.
     *
     * @param canvas The canvas to draw on.
     * @param paint  The paint to use to draw on canvas.
     */
    @Override
    void draw(Canvas canvas, Paint paint) {
        paint.setColor(getTextColor());
        canvas.drawText(moveText, getX(), getY(), paint);
    }

    /**
     * Overridden method that updates the Move Text object.
     */
    @Override
    void update() {

    }

    /**
     * Overloaded method for update. Updates the text to display (the move the Character makes).
     *
     * @param displayText The text to display (the move the Character makes).
     * @param color       The color of the text to display.
     */
    void update(String displayText, int color) {
        setTextColor(color);
        setMoveText(displayText);

    }

}
