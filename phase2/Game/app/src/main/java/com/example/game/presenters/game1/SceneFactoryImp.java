package com.example.game.presenters.game1;

/**
 * SceneFactoryImp class.
 */
public class SceneFactoryImp implements SceneFactory {

    @Override
    public Scene makeGameplayScene() {
        return new GameplayScene();
    }
}
