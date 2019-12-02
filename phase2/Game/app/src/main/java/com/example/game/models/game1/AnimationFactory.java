package com.example.game.models.game1;

import android.graphics.Bitmap;

/**
 * AnimationFactory interface
 */
interface AnimationFactory {
    Animation makeBallAnimation(Bitmap[] frames, float animTime);
}
