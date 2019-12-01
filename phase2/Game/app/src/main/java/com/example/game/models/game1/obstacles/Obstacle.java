package com.example.game.models.game1.obstacles;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.game.models.game1.rectplayer.RectPlayer;

public interface Obstacle {
    boolean playerCollide(RectPlayer player);

    void incrementY(float y);

    Rect getRectangle();

    void draw(Canvas canvas); // Draw GameObject

    void update(); // Update GameObject
}
