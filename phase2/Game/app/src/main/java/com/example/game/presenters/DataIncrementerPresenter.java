package com.example.game.presenters;

import com.example.game.models.DataIncrementerUseCases;
import com.example.game.models.interfaces.DataIncrementerActions;
import com.example.game.models.interfaces.DataIncrementerListener;

import java.io.File;

public class DataIncrementerPresenter implements DataIncrementerListener {
    private DataIncrementerUseCases useCases;
    private DataIncrementerActions actions;

    public DataIncrementerPresenter(DataIncrementerActions dataIncrementerActions, DataIncrementerUseCases useCases){
        this.useCases = useCases;
        this.actions = dataIncrementerActions;
    }

    public void incrementLevel(File contextFile){
        useCases.incrementThenNext(this, contextFile);
    }

    public void decrementLevel(File contextFile){
        useCases.decrementThenAgain(this, contextFile);
    }

    @Override
    public void doAgain() {
        actions.toRetry();
    }

    @Override
    public void next() {
        actions.toNext();
    }
}
