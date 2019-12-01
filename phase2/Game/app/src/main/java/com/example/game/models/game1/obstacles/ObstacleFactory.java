package com.example.game.models.game1.obstacles;

import com.example.game.models.game1.obstacles.Obstacle;

public interface ObstacleFactory {
    Obstacle makeBallJumpObstacle(int rectHeight, int color, int startX, int startY);
}
