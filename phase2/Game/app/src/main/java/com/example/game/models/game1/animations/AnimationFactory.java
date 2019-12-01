package com.example.game.models.game1.animations;

import android.graphics.Bitmap;

import com.example.game.models.game1.animations.Animation;

public interface AnimationFactory {
    Animation makeBallAnimation(Bitmap[] frames, float animTime);
}
