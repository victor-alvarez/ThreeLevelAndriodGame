package com.example.game.models.game1.animations;

import android.graphics.Bitmap;

/**
 * AnimationFactoryImpl class. Returns BallAnimation object.
 */
public class AnimationFactoryImpl implements AnimationFactory {

    @Override
    public Animation makeBallAnimation(Bitmap[] frames, float animTime){
        return new BallAnimation(frames, animTime);
    }
}
