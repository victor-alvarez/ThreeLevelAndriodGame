package com.example.game.models.game1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;

import com.example.game.R;

/**
 * RectPlayer class. The actual player the user will control.
 */
public class BallJumpRectPlayer implements RectPlayer{

    /**
     * Instance variables
     */
    private Rect rectangle;
    private AnimationManager animManager;

    /**
     * Constructor
     *
     * @param rectangle - the players rectangle
     */
    public BallJumpRectPlayer(Rect rectangle) {
        this.rectangle = rectangle;
        animManager = new AnimationManager();
    }

    /**
     * @return - this players rectangle
     */
    @Override
    public Rect getRectangle() {
        return rectangle;
    }

    @Override
    public void draw(Canvas canvas) {
        // Paint paint = new Paint();
        // paint.setColor(color);
        // canvas.drawRect(rectangle, paint);
        animManager.draw(canvas, rectangle);
    }

    public void update() {
        animManager.update();
    }

    /**
     * @param point - Take in coordinates and move player to those coordinates
     */
    @Override
    public void update(Point point) {
        float oldLeft = rectangle.left;

        rectangle.set(point.x - rectangle.width() / 2, point.y - rectangle.height() / 2, point.x + rectangle.width() / 2, point.y + rectangle.height() / 2);

        int state = 0;
        if (rectangle.left - oldLeft > 5) {
            state = 1;
        } else if (rectangle.left - oldLeft < -5) {
            state = 2;
        }

        animManager.playAnim(state);
        animManager.update();
    }
}
