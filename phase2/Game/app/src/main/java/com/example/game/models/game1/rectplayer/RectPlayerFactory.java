package com.example.game.models.game1.rectplayer;

import android.graphics.Rect;

import com.example.game.models.game1.rectplayer.RectPlayer;

public interface RectPlayerFactory {
    RectPlayer makeBallJumpRectPlayer(Rect rectangle);
}
