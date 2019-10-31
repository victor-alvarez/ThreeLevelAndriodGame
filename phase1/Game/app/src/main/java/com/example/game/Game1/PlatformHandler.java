package com.example.game.Game1;

import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.ArrayList;

public class PlatformHandler {
    /**
     * Instance Variables
      */
    private ArrayList<Platform> platforms;
    private int color;

    /**
     * color - The color of the platforms within PlatformHandler
     * @param color
     */
    public PlatformHandler(int color) {
        this.color = color;
        platforms = new ArrayList<>();
        populatePlatforms();
    }

    /**
     * Construct level for game by filling up platforms with Platform objects
     */
    private void populatePlatforms() {
        for (int x = 0; x < Constants.SCREEN_WIDTH; x += 200) {
            Platform platform = new Platform(new Rect(x, 3 * Constants.SCREEN_HEIGHT/4 + 100, x + 100,
                    3 * Constants.SCREEN_HEIGHT/4 + 200), color);
            Platform platform2 = new Platform(new Rect(x, 1 * Constants.SCREEN_HEIGHT/2, x + 100,
                    1 * Constants.SCREEN_HEIGHT/2 + 100), color);
            // Randomly add the obstacles
            double yes = Math.random();
            if (yes < 0.5) {
                platforms.add(platform);
            } else {platforms.add(platform2);}

        }
    }

    /**
     * Loop through platforms and draw all of them
     */
    public void draw(Canvas canvas) {
        for (Platform p: platforms) {
            p.draw(canvas);
        }
    }




}
