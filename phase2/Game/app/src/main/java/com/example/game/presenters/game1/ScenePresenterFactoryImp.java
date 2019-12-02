package com.example.game.presenters.game1;

public class ScenePresenterFactoryImp implements ScenePresenterFactory {

    @Override
    public ScenePresenter makeScenePresenterImp() {
        return new ScenePresenterImp();
    }
}
