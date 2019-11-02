package com.example.game.Game3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.game.R;

import static java.lang.StrictMath.max;

/**
 * A Health Bar Game 3 Object class.
 */
public class HealthBarObject extends Game3Object {

    /**
     * Color of the Health Bar
     */
    private int color;

    /**
     * The size of the text that displays the Health
     */
    private int textSize;

    /**
     * The name of the Player who is represented by this Health Bar.
     */
    private String playerName;

    /**
     * Current level of the Health Bar, initialized to 100.
     */
    private int healthLevel = 100;

    /**
     * Getter for the health level of the Health Bar.
     *
     * @return healthLevel : The health level of the Health Bar.
     */
    public int getHealthLevel() {
        return healthLevel;
    }

    /**
     * Setter for the health level of this Health Bar.
     *
     * @param healthLevel The health level of this Health Bar.
     */
    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    /**
     * Getter for the player name.
     *
     * @return playerName: The name of the Player with this Health Bar.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Setter for player name.
     *
     * @param playerName The name of the Player with this Health Bar.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Getter for the text size that displays the health level.
     *
     * @return textSize : the size of the text that displays the health level.
     */
    public int getTextSize() {
        return textSize;
    }

    /**
     * Setter for the text size that displays the health level.
     *
     * @param textSize : the size of the text that displays the health level.
     */
    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    /**
     * Getter for the color of the Health Bar.
     *
     * @return color : the color of the Health Bar.
     */
    public int getColor() {
        return color;
    }

    /**
     * Setter for the color of the Health Bar.
     *
     * @param color The color of the Health Bar.
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * Overridden method that draws the Health Bar on given canvas.
     *
     * @param canvas The canvas to draw on.
     * @param paint  The paint to use to draw on canvas.
     */
    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        paint.setTextSize(textSize);
        canvas.drawText(playerName.toUpperCase() + getHealthLevel(), getX(), getY(), paint);
    }

    /**
     * Overridden method that updates the Health Bar object.
     */
    @Override
    public void update() {

    }

    /**
     * Overloaded method for update. Updates the health level of this Health Bar.
     *
     * @param damage The amount of health to reduce from the health level.
     */
    public void update(int damage) {
        setHealthLevel(max(0, getHealthLevel() - damage));
    }
}
