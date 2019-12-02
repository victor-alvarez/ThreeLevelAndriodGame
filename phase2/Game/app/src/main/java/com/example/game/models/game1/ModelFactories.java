package com.example.game.models.game1;

import com.example.game.models.game1.animations.AnimationFactory;
import com.example.game.models.game1.animations.AnimationManagerFactory;
import com.example.game.models.game1.obstacles.ObstacleFactory;
import com.example.game.models.game1.obstacles.ObstacleManagerFactory;
import com.example.game.models.game1.orientation.OrientationDataFactory;
import com.example.game.models.game1.rectplayer.RectPlayerFactory;
import com.example.game.models.game1.scenes.SceneFactory;

/**
 * ModelFactories class
 */
public class ModelFactories {
    public static ObstacleFactory OBSTACLE_FACTORY;
    public static RectPlayerFactory RECT_PLAYER_FACTORY;
    public static ObstacleManagerFactory OBSTACLE_MANAGER_FACTORY;
    public static AnimationFactory ANIMATION_FACTORY;
    public static AnimationManagerFactory ANIMATION_MANAGER_FACTORY;
    public static OrientationDataFactory ORIENTATION_DATA_FACTORY;
    public static SceneFactory SCENE_FACTORY;
}
