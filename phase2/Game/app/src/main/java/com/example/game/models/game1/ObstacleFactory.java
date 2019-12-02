package com.example.game.models.game1;

/**
 * ObstacleFactory interface.
 */
interface ObstacleFactory {
    Obstacle makeBallJumpObstacle(int rectHeight, int color, int startX, int startY);
}
