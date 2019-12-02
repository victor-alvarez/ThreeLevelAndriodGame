package com.example.game.viewLevel.game1;

import android.content.Context;

public class Game1ViewFactoryImpl implements Game1ViewFactory {

    @Override
    public Game1View makeGame1ViewImpl(Context context) {
        return new Game1ViewImpl(context);
    }
}
