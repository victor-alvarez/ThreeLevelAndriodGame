package com.example.game.models.game1.obstacles;

import android.graphics.Canvas;

import com.example.game.models.game1.rectplayer.RectPlayer;

import java.util.ArrayList;

/**
 * ObstacleManager interface.
 */
public interface ObstacleManager {
    void setDifficulty(String difficulty); // Sets difficulty for game

    void draw(Canvas canvas); // Draws obstacles

    ArrayList<Obstacle> getObstacles(); // Returns list of obstacles

    void update(); // updates through game loop

    boolean playerCollide(RectPlayer player); // returns true iff collides with player

    void addObstacle(); // adds obstacle to list of obstacles
}
