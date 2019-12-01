package com.example.game.models.game1.animations;

import android.graphics.Canvas;
import android.graphics.Rect;

public interface Animation {
    boolean isPlaying();

    void play();

    void stop();

    void draw(Canvas canvas, Rect rect);

    void update();
}
