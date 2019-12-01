package com.example.game.models.game1.animations;

import android.graphics.Bitmap;

public class AnimationFactoryImpl implements AnimationFactory {
    public Animation makeBallAnimation(Bitmap[] frames, float animTime){
        return new BallAnimation(frames, animTime);
    }
}
