package com.example.game.models.game1.scenes;

/**
 * SceneFactoryImp class.
 */
public class SceneFactoryImp implements SceneFactory {

    @Override
    public Scene makeGameplayScene() {
        return new GameplayScene();
    }
}
