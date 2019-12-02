package com.example.game.viewLevel.game1;

import android.view.SurfaceHolder;

public class MainThreadFactoryImpl implements MainThreadFactory {

    @Override
    public MainThread makeGame1Thread(SurfaceHolder surfaceHolder, Game1View game1View) {
        return new Game1Thread(surfaceHolder, game1View);
    }
}
