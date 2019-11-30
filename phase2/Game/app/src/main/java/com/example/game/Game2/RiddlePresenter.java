package com.example.game.Game2;

import android.content.Intent;

import com.example.game.GameOver;
import com.example.game.models.game2.RiddleActions;
import com.example.game.models.game2.RiddleListener;

import java.io.File;
import java.util.ArrayList;

public class RiddlePresenter implements RiddleListener {

    private RiddleActions riddleActions;
    private RiddleUseCases riddleUseCases;


    RiddlePresenter (RiddleActions riddleActions, RiddleUseCases riddleUseCases){
        this.riddleActions = riddleActions;
        this.riddleUseCases = riddleUseCases;
    }

    public void determineRightOrWrong(String[] riddleStrings, String clickedString, File contextFile){
        riddleUseCases.actOnCorrectness(riddleStrings, clickedString, this, contextFile);
    }

    public void nextRiddle(ArrayList<Integer> remainingRiddles, File contextFile){
        riddleUseCases.activateNextRiddle(remainingRiddles, this, contextFile);
    }

    @Override
    public void endOfRiddles(){
        riddleActions.finishRiddles();
    }

    @Override
    public void rightAnswer(){
        riddleActions.rightAnswer();
    }

    @Override
    public void wrongAnswer(){
        riddleActions.wrongAnswer();
    }

    @Override
    public void moreRiddles(){
        riddleActions.setNewRiddleText();
    }

    @Override
    public void noLivesLeft() {
        riddleActions.noLivesLeft();
    }
}
