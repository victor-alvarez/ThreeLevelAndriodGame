package com.example.game.Game1;

import android.graphics.Canvas;
import android.graphics.Rect;

public class AnimationManager {
    /**
     * Manages the animations.
     */

    // === Instance Variables ===

    private Animation[] animations; // The animations this class will manage.
    private int animationIndex = 0; // The index of the current animation being managed.

    /**
     * Creates a new Animation.
     *
     * @param animations the array of animations that is stored.
     */
    AnimationManager(Animation[] animations) {
        this.animations = animations;
    }

    /**
     * Plays the animation at a specified index.
     *
     * @param index the index where we want to play the animation.
     */
    void playAnim(int index) {
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
    public void draw(Canvas canvas, Rect rect) {
        if (animations[animationIndex].isPlaying()) {
            animations[animationIndex].draw(canvas, rect);
        }
    }

    /**
     * Updates the animation at the animationIndex
     */
    public void update() {
        if (animations[animationIndex].isPlaying()) {
            animations[animationIndex].update();
        }
    }
}
