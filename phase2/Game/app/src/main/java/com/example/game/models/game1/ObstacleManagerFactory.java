package com.example.game.models.game1;

public interface ObstacleManagerFactory {
    ObstacleManager makeObstacleManagerImpl(int obstacleGap, int obstacleHeight, int color);
}
