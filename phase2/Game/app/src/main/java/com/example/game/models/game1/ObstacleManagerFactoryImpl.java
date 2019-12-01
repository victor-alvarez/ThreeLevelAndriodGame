package com.example.game.models.game1;

public class ObstacleManagerFactoryImpl implements ObstacleManagerFactory {
    public ObstacleManager makeObstacleManagerImpl(int obstacleGap, int obstacleHeight, int color) {
        return new ObstacleManagerImpl(obstacleGap, obstacleHeight, color);
    }
}
