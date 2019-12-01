package com.example.game.models.game1;

import android.graphics.Bitmap;

public interface AnimationFactory {
    Animation makeBallAnimation(Bitmap[] frames, float animTime);
}
