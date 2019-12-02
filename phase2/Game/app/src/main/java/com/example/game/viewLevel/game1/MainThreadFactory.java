package com.example.game.viewLevel.game1;

import android.view.SurfaceHolder;

interface MainThreadFactory {
    MainThread makeGame1Thread(SurfaceHolder surfaceHolder, Game1View game1View);
}
