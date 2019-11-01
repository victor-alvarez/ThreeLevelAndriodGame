package com.example.game.Game3;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import static java.lang.StrictMath.max;

public class HealthBarObject extends Game3Object {

    private int color;

    private int textSize;

    private String playerName;

    private int healthLevel = 100;

    public int getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(color);
        paint.setTextSize(textSize);
        canvas.drawText(playerName.toUpperCase() + "'S HP: " + healthLevel, getX(), getY(),
                paint);
    }

    @Override
    public void update() {

    }

    public void update(int damage) {
        setHealthLevel(max(0, getHealthLevel() - damage));
    }
}
