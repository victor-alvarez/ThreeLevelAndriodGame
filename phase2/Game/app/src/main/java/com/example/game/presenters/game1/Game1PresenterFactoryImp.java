package com.example.game.presenters.game1;

public class Game1PresenterFactoryImp implements Game1PresenterFactory {

    @Override
    public Game1Presenter makeGame1PresenterImp() {
        return new SceneManager();
    }
}
