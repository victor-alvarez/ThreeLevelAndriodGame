package com.example.game;

import com.example.game.models.ActivityDataResponseActions;
import com.example.game.models.ActivityDataResponseListener;

import java.io.File;

public class ActivityDataPresenter implements ActivityDataResponseListener{
    private ActivityDataResponseActions dataResponseActions;
    private ActivityDataUseCases dataUseCases;

    ActivityDataPresenter(ActivityDataResponseActions dataResponseActions,
                          ActivityDataUseCases dataUseCases){
        this.dataResponseActions = dataResponseActions;
        this.dataUseCases = dataUseCases;
    }

    void resetDataValues(File contextFile){
        dataUseCases.resetData(this, contextFile);
    }

    @Override
    public void reactToReset() {
        dataResponseActions.reactToReset();
    }
}
