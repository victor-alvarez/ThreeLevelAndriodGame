package com.example.game.viewLevel.game1;

import android.content.Context;

class Game1ViewFactoryImpl implements Game1ViewFactory {

    @Override
    public Game1View makeGame1ViewImpl(Context context) {
        return new GamePanel(context);
    }
}
