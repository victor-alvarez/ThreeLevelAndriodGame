package com.example.game.models.game1.scenes;

public class SceneFactoryImp implements SceneFactory {

    @Override
    public Scene makeGameplayScene() {
        return new GameplayScene();
    }
}
