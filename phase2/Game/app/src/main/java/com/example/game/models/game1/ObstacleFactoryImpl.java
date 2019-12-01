package com.example.game.models.game1;

public class ObstacleFactoryImpl implements ObstacleFactory {

    @Override
    public Obstacle makeBallJumpObstacle(int rectHeight, int color, int startX, int startY) {
        return new BallJumpObstacle(rectHeight, color, startX, startY);
    }
}
