package com.example.game.models.game1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;

import com.example.game.R;

/**
 * AnimationManagerImpl class. Manages the animations.
 */
class AnimationManagerImpl implements AnimationManager {
    // === Instance Variables ===

    private Animation[] animations; // The animations this class will manage.
    private int animationIndex = 0; // The index of the current animation being managed.

    /**
     * Creates a new Animation.
     */
    AnimationManagerImpl() {
        AnimationFactory animationFactory = ModelFactories.ANIMATION_FACTORY;

        Bitmap idleImg = BitmapFactory.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienblue_badge1);
        Bitmap walk1 = BitmapFactory.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienblue_badge1);
        Bitmap walk2 = BitmapFactory.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.alienblue_badge1);

        Animation idle = animationFactory.makeBallAnimation(new Bitmap[]{idleImg}, 2);
        Animation walkRight = animationFactory.makeBallAnimation(new Bitmap[]{walk1, walk2}, 0.5f);

        Matrix m = new Matrix();
        m.preScale(-1, 1);
        walk1 = Bitmap.createBitmap(walk1, 0, 0, walk1.getWidth(), walk1.getHeight(), m, false);
        walk2 = Bitmap.createBitmap(walk1, 0, 0, walk2.getWidth(), walk2.getHeight(), m, false);

        Animation walkLeft = animationFactory.makeBallAnimation(new Bitmap[]{walk1, walk2}, 0.5f);
        animations = new Animation[]{idle, walkRight, walkLeft};
    }

    /**
     * Plays the animation at a specified index.
     *
     * @param index the index where we want to play the animation.
     */
    @Override
    public void playAnim(int index) {
        for (int i = 0; i < animations.length; i++) {
            if (i == index) {
                if (!animations[index].isPlaying()) {
                    animations[i].play();
                }
            } else {
                animations[i].stop();
            }
        }
        animationIndex = index;
    }

    /**
     * Draws the animation at the animationIndex.
     *
     * @param canvas the canvas on which to draw.
     * @param rect   the rectangle that will be "drawn" on the canvas.
     */
    @Override
    public void draw(Canvas canvas, Rect rect) {
        if (animations[animationIndex].isPlaying()) {
            animations[animationIndex].draw(canvas, rect);
        }
    }

    /**
     * Updates the animation at the animationIndex
     */
    @Override
    public void update() {
        if (animations[animationIndex].isPlaying()) {
            animations[animationIndex].update();
        }
    }
}
