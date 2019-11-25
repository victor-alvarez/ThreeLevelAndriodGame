package com.example.game.data;

import android.graphics.Canvas;

/**
 * GameObject interface.
 */
public interface GameObject {
    void draw(Canvas canvas); // Draw GameObject

    void update(); // Update GameObject
}
