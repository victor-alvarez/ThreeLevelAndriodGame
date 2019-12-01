package com.example.game.models.game1;

import android.graphics.Rect;

public class RectPlayerFactoryImpl implements RectPlayerFactory {
    public RectPlayer makeBallJumpRectPlayer(Rect rectangle){
        return new BallJumpRectPlayer(rectangle);
    }
}
