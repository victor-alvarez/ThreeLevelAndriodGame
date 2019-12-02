package com.example.game.viewLevel.game1;

import android.graphics.Canvas;

interface Game1View {
    void setDifficulty(String difficulty);

    void update();

    void draw(Canvas canvas);
}
