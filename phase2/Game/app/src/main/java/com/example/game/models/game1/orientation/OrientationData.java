package com.example.game.models.game1.orientation;

/**
 * OrientationData interface
 */
public interface OrientationData {
    float[] getOrientation(); // returns device orientation

    float[] getStartOrientation(); // returns device starting orientation

    void register(); // registers device
}
