package com.example.game.data;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.game.data.Obstacle;

/**
 * Constants class. Place to hold all constant variables like screen width.
 */
public class Constants {
    /**
     * Constant variables
     */
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    @SuppressLint("StaticFieldLeak")
    public static Context CURRENT_CONTEXT;
    public static long INIT_TIME;
    public static Obstacle hitTile;
}
