package com.example.game.models.game1;

import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * ObstacleManager class. Creates obstacles to be populated in game.
 */
public class ObstacleManager {
    // higher index = lower on screen = higher y value

    /**
     * Instance variables
     */
    private ArrayList<Obstacle> obstacles;
    private int obstacleGap;
    private int obstacleHeight;
    private int color;
    private long startTime;

    /**
     * Constructor for ObstacleManager
     *
     * @param obstacleGap    - gap between spawning obstacles
     * @param obstacleHeight - height of obstacles
     * @param color          - color of obstacles
     */
    public ObstacleManager(int obstacleGap, int obstacleHeight, int color) {
        this.obstacleGap = obstacleGap;
        this.obstacleHeight = obstacleHeight;
        this.color = color;
        obstacles = new ArrayList<>();
        populateObstacles();
    }

    /**
     * @param player - RectPlayer player to check collision with any of the obstacles
     * @return - true iff any obstacle in obstacles collides with player
     */
    public boolean playerCollide(RectPlayer player) {
        for (Obstacle ob : obstacles) {
            if (ob.playerCollide(player)) {
                Constants.hitTile = ob;
                return true;
            }
        }
        return false;
    }

    /**
     * Add obstacles below each other to bottom of the screen.
     */
    public void populateObstacles() {
        int currY = Constants.SCREEN_HEIGHT * 2;

        while (currY > Constants.SCREEN_HEIGHT) {
            int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - 100));
            obstacles.add(new Obstacle(obstacleHeight, color, xStart, currY));
            currY -= obstacleHeight + obstacleGap;
        }
    }

    /**
     * Loop through ArrayList of obstacles and move them. Check if obstacle is off screen on the
     * top, then add new obstacle objects to the bottom.
     */
    public void update() {
        if (startTime < Constants.INIT_TIME) {
            startTime = Constants.INIT_TIME;
        }
        int elapseTime = (int) (System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        for (Obstacle ob : obstacles) {
            ob.incrementY(-1 * elapseTime);
        }
        if (obstacles.get(obstacles.size() - 1).getRectangle().bottom <= 0) {
            int xStart = (int) (Math.random() * (Constants.SCREEN_WIDTH - 100));
            obstacles.add(0, new Obstacle(obstacleHeight, color, xStart, obstacles.get(0).getRectangle().top + obstacleHeight + obstacleGap));
        }
    }

    /**
     * Getter for list of obstacles
     **/
    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    /**
     * @param canvas - draw to Canvas canvas
     */
    public void draw(Canvas canvas) {
        for (Obstacle ob : obstacles) {
            ob.draw(canvas);
        }
    }
}
