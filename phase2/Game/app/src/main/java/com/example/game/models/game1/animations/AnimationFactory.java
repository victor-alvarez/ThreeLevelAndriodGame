package com.example.game.models.game1.animations;

import android.graphics.Bitmap;


/**
 * AnimationFactory interface
 */
public interface AnimationFactory {
    Animation makeBallAnimation(Bitmap[] frames, float animTime);
}
