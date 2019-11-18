package com.example.game.Game1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Obstacle class. These are the individual obstacles to be spawned by ObstacleManager
 */
public class Obstacle implements GameObject {

    /**
     * Instance variables
     */
    private Rect rectangle;
    private int color;
    private boolean destroy = false;

    /**
     * Constructor
     *
     * @param rectHeight - the height of the obstacle
     * @param color      - the color of the obstacle
     * @param startX     - the starting x position of the obstacle
     * @param startY     - the starting y position of the obstacle
     */
    Obstacle(int rectHeight, int color, int startX, int startY) {
        this.color = color;
        //l,t,r,b
        rectangle = new Rect(startX, startY, startX + 100, startY + rectHeight);
    }

    /**
     * @return - rectangle
     */
    Rect getRectangle() {
        return rectangle;
    }

    /**
     * @param y - Move obstacle vertical position by an increment of y
     */
    void incrementY(float y) {
        rectangle.top += y;
        rectangle.bottom += y;
    }

    /**
     * @param player - RectPlayer player to be checked collision with
     * @return - return true iff player's rectangle intersects with obstacles rectangle
     */
    boolean playerCollide(RectPlayer player) {
        return Rect.intersects(rectangle, player.getRectangle());
    }

    @Override
    public void draw(Canvas canvas) {
        if (!destroy) {
            Paint paint = new Paint();
            paint.setColor(color);
            canvas.drawRect(rectangle, paint);
        }
    }

    @Override
    public void update() {

    }

    /**
     * Destroys Obstacle
     */
    void destroy() {
        destroy = true;
    }

    /**
     * @return - whether Obstacle has been destroyed
     */
    boolean checkDestoryed() {
        return destroy;
    }
}
