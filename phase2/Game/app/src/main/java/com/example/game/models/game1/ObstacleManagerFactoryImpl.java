package com.example.game.models.game1;


/**
 * ObstacleManagerFactoryImpl class.
 */
public class ObstacleManagerFactoryImpl implements ObstacleManagerFactory {

    @Override
    public ObstacleManager makeObstacleManagerImpl(int obstacleGap, int obstacleHeight, int color) {
        return new ObstacleManagerImpl(obstacleGap, obstacleHeight, color);
    }
}
