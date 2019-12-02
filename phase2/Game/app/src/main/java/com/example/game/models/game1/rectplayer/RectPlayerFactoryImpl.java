package com.example.game.models.game1.rectplayer;

import android.graphics.Rect;


/**
 * RectPlayerFactoryImpl class.
 */
public class RectPlayerFactoryImpl implements RectPlayerFactory {

    @Override
    public RectPlayer makeBallJumpRectPlayer(Rect rectangle){
        return new BallJumpRectPlayer(rectangle);
    }
}
