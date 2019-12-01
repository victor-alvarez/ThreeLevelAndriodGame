package com.example.game.Game3;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * A Move Text Game 3 Object class that displays the Move a Character makes
 */
class MoveTextObject extends Game3Object {

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
    int getTextColor() {
        return textColor;
    }

    /**
     * Setter for the the color of the Text to display.
     *
     * @param textColor The color of the Text to display.
     */
    void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    /**
     * Getter for the Text to display.
     *
     * @return moveText : The Text to display.
     */
    String getMoveText() {
        return moveText;
    }

    /**
     * Setter for the Text to display.
     *
     * @param moveText : The Text to display.
     */
    void setMoveText(String moveText) {
        this.moveText = moveText;
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
