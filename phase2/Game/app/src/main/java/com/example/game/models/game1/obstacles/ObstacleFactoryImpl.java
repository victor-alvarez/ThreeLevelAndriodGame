package com.example.game.models.game1.obstacles;

import com.example.game.models.game1.obstacles.BallJumpObstacle;
import com.example.game.models.game1.obstacles.Obstacle;
import com.example.game.models.game1.obstacles.ObstacleFactory;

public class ObstacleFactoryImpl implements ObstacleFactory {

    @Override
    public Obstacle makeBallJumpObstacle(int rectHeight, int color, int startX, int startY) {
        return new BallJumpObstacle(rectHeight, color, startX, startY);
    }
}
