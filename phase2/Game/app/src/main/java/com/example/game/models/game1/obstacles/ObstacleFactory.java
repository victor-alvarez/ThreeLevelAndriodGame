package com.example.game.models.game1.obstacles;

/**
 * ObstacleFactory interface.
 */
public interface ObstacleFactory {
    Obstacle makeBallJumpObstacle(int rectHeight, int color, int startX, int startY);
}
