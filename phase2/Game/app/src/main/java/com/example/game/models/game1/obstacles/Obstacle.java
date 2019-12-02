package com.example.game.models.game1.obstacles;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.game.models.game1.rectplayer.RectPlayer;

/**
 * Obstacle interface.
 */
public interface Obstacle {
    boolean playerCollide(RectPlayer player);

    void incrementY(float y); // Move by y

    Rect getRectangle(); // Returns rectangle

    void draw(Canvas canvas); // Draw GameObject

    void update(); // Update GameObject
}
