package com.example.game.models.game3;

import android.graphics.Rect;

/**
 * A class for Button.
 */
class ButtonObject extends Game3Object {

    /**
     * The physical representation of the ButtonObject as a rectangle object
     */
    private Rect button;

    /**
     * Boolean that decides if the ButtonObject is active or not.
     */
    private boolean active = true;

    /**
     * The color of the ButtonObject.
     */
    private int btnColor;

    /**
     * The color of the ButtonObject label
     */
    private int textColor;

    /**
     * The label for the ButtonObject
     */
    private String btnName;

    /**
     * A getter for ButtonObject Name.
     *
     * @return btnName : The ButtonObject Name.
     */
    String getBtnName() {
        return btnName;
    }

    /**
     * Setter for ButtonObject Name.
     *
     * @param btnName The ButtonObject Name.
     */
    void setBtnName(String btnName) {
        this.btnName = btnName;
    }

    /**
     * Getter for the TextColor.
     *
     * @return textColor : The color of the ButtonObject Label.
     */
    int getTextColor() {
        return textColor;
    }

    /**
     * Setter for TextColor
     *
     * @param textColor : The color of the ButtonObject Label.
     */
    void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    /**
     * Getter for ButtonObject Color.
     *
     * @return btnColor : the color of the ButtonObject.
     */
    int getBtnColor() {
        return btnColor;
    }

    /**
     * Setter for ButtonObject Color.
     *
     * @param color The color of the ButtonObject.
     */
    void setBtnColor(int color) {
        this.btnColor = color;
    }

    /**
     * Getter for ButtonObject active.
     *
     * @return active : Checks if ButtonObject is active.
     */
    boolean isActive() {
        return active;
    }

    /**
     * Setter for ButtonObject active.
     *
     * @param active Sets the button active or not.
     */
    void setActive(boolean active) {
        this.active = active;
    }


    /**
     * Getter for physical representation of the ButtonObject.
     *
     * @return button : The physical representation of the ButtonObject.
     */
    Rect getButton() {
        return button;
    }

    /**
     * Setter for the physical representation of the ButtonObject.
     *
     * @param button The physical representation of the ButtonObject.
     */
    void setButton(Rect button) {
        this.button = button;
    }

    /**
     * Overrides update for the ButtonObject from GameObject class.
     */
    @Override
    void update() {

    }
}
