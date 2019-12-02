package com.example.game.models.game1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;


/**
 * Obstacle class. These are the individual obstacles to be spawned by ObstacleManager
 */
class BallJumpObstacle implements Obstacle {

    /**
     * Instance variables
     */
    private Rect rectangle;
    private int color;

    /**
     * Constructor
     *
     * @param rectHeight - the height of the obstacle
     * @param color      - the color of the obstacle
     * @param startX     - the starting x position of the obstacle
     * @param startY     - the starting y position of the obstacle
     */
    BallJumpObstacle(int rectHeight, int color, int startX, int startY) {
        this.color = color;
        //l,t,r,b
        rectangle = new Rect(startX, startY, startX + 100, startY + rectHeight);
    }

    /**
     * @return - rectangle
     */
    public Rect getRectangle() {
        return rectangle;
    }

    /**
     * @param y - Move obstacle vertical position by an increment of y
     */
    @Override
    public void incrementY(float y) {
        rectangle.top += y;
        rectangle.bottom += y;
    }

    /**
     * @param player - RectPlayer player to be checked collision with
     * @return - return true iff player's rectangle intersects with obstacles rectangle
     */
    @Override
    public boolean playerCollide(RectPlayer player) {
        return Rect.intersects(rectangle, player.getRectangle());
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void update() {

    }
}