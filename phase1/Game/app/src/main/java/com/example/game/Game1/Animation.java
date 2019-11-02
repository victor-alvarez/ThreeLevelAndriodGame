package com.example.game.Game1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Animation {
    /**
     * Handles the animation of the player-controlled ball in the game.
     */

    // === Instance Variables ===

    private Bitmap[] frames; // The images.
    private int frameIndex; // The index associated with frames.
    private boolean isPlaying = false; // Whether or not the game is playing.
    private float frameTime; // The time in between frames.
    private long lastFrame; //

    /**
     * Creates a new Animation.
     *
     * @param frames   the images.
     * @param animTime the animation time.
     */
    public Animation(Bitmap[] frames, float animTime) {
        this.frames = frames;
        frameIndex = 0;
        frameTime = animTime / frames.length;
        lastFrame = System.currentTimeMillis();
    }

    /**
     * A getter method for isPlaying.
     */
    public boolean isPlaying() {
        return isPlaying;
    }

    /**
     * Sets isPlaying to true, frameIndex to 0, and lastFrame to the current time in milliseconds.
     */
    public void play() {
        isPlaying = true;
        frameIndex = 0;
        lastFrame = System.currentTimeMillis();
    }

    /**
     * Sets isPlaying to false.
     */
    public void stop() {
        isPlaying = false;
    }

    /**
     * Draws this animation on the canvas.
     *
     * @param canvas      the canvas on which to draw.
     * @param destination the rectangle that will be "drawn" on the canvas.
     */
    public void draw(Canvas canvas, Rect destination) {
        if (!isPlaying) {
            return;
        }

        scaleRect(destination);

        canvas.drawBitmap(frames[frameIndex], null, destination, new Paint());
    }

    /**
     * Scales the given rectangle for the draw method.
     *
     * @param rect the rectangle to be scaled.
     */
    private void scaleRect(Rect rect) {
        float whRatio = (float) (frames[frameIndex].getWidth()) / frames[frameIndex].getHeight();
        if (rect.width() > rect.height()) {
            rect.left = rect.right - (int) (rect.height() * whRatio);
        } else {
            rect.top = rect.bottom - (int) (rect.width() * (1 / whRatio));
        }
    }

    /**
     * Updates this animation.
     */
    public void update() {
        if (!isPlaying) {
            return;
        }

        if (System.currentTimeMillis() - lastFrame > frameTime * 1000) {
            frameIndex++;
            if (frameIndex >= frames.length) {
                frameIndex = 0;
            }
            lastFrame = System.currentTimeMillis();
        }
    }
}
