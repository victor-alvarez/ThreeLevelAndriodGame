package com.example.game.Game2;

import com.example.game.models.game2.RiddleActions;
import com.example.game.models.game2.RiddleListener;

import java.util.ArrayList;

public class RiddlePresenter implements RiddleListener {

    private RiddleActions riddleActions;
    private RiddleUseCases riddleUseCases;


    RiddlePresenter (RiddleActions riddleActions, RiddleUseCases riddleUseCases){
        this.riddleActions = riddleActions;
        this.riddleUseCases = riddleUseCases;
    }

    public void determineRightOrWrong(String[] riddleStrings, String clickedString){
        riddleUseCases.actOnCorrectness(riddleStrings, clickedString, this);
    }

    public void nextRiddle(ArrayList<Integer> remainingRiddles){
        riddleUseCases.activateNextRiddle(remainingRiddles, this);
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
}
