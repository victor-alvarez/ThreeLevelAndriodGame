package com.example.game.models.game1;

public class AnimationManagerFactoryImpl implements AnimationManagerFactory {

    @Override
    public AnimationManager makeAnimationManagerImpl() {
        return new AnimationManagerImpl();
    }
}
