package com.example.game.Game1;

import android.annotation.SuppressLint;
import android.content.Context;

/**
 * Constants class. Place to hold all constant variables like screen width.
 */
class Constants {
    /**
     * Constant variables
     */
    static int SCREEN_WIDTH;
    static int SCREEN_HEIGHT;
    @SuppressLint("StaticFieldLeak")
    static Context CURRENT_CONTEXT;
    static long INIT_TIME;
    static Obstacle hitTile;
}
