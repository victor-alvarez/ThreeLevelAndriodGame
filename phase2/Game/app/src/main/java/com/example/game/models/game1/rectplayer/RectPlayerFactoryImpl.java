package com.example.game.models.game1.rectplayer;

import android.graphics.Rect;

import com.example.game.models.game1.rectplayer.BallJumpRectPlayer;
import com.example.game.models.game1.rectplayer.RectPlayer;
import com.example.game.models.game1.rectplayer.RectPlayerFactory;

public class RectPlayerFactoryImpl implements RectPlayerFactory {

    @Override
    public RectPlayer makeBallJumpRectPlayer(Rect rectangle){
        return new BallJumpRectPlayer(rectangle);
    }
}
