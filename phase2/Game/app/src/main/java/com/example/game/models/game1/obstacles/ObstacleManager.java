package com.example.game.models.game1.obstacles;

import android.graphics.Canvas;

import com.example.game.models.game1.rectplayer.RectPlayer;

import java.util.ArrayList;

public interface ObstacleManager {
    void setDifficulty(String difficulty);

    void draw(Canvas canvas);

    ArrayList<Obstacle> getObstacles();

    void update();

    boolean playerCollide(RectPlayer player);

    void addObstacle();
}