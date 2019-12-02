package com.example.game.models.game1;

/**
 * ObstacleManagerFactory interface.
 */
public interface ObstacleManagerFactory {
    ObstacleManager makeObstacleManagerImpl(int obstacleGap, int obstacleHeight, int color);
}
