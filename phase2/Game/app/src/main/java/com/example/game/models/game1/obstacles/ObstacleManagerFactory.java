package com.example.game.models.game1.obstacles;

import com.example.game.models.game1.obstacles.ObstacleManager;

public interface ObstacleManagerFactory {
    ObstacleManager makeObstacleManagerImpl(int obstacleGap, int obstacleHeight, int color);
}
