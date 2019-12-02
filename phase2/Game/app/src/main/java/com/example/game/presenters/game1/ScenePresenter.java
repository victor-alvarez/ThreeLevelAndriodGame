package com.example.game.presenters.game1;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface ScenePresenter {
    void setDifficulty(String difficulty);

    void receiveTouch(MotionEvent event);

    void update();

    void draw(Canvas canvas);
}
