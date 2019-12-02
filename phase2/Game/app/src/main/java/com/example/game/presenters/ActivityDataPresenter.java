package com.example.game.presenters;

import com.example.game.models.ActivityDataUseCases;
import com.example.game.models.interfaces.ActivityDataResponseActions;
import com.example.game.models.interfaces.ActivityDataResponseListener;

import java.io.File;

public class ActivityDataPresenter implements ActivityDataResponseListener{
    private ActivityDataResponseActions dataResponseActions;
    private ActivityDataUseCases dataUseCases;

    public ActivityDataPresenter(ActivityDataResponseActions dataResponseActions,
                          ActivityDataUseCases dataUseCases){
        this.dataResponseActions = dataResponseActions;
        this.dataUseCases = dataUseCases;
    }

    public void resetDataValues(File contextFile){
        dataUseCases.resetData(this, contextFile);
    }

    @Override
    public void reactToReset() {
        dataResponseActions.reactToReset();
    }
}
