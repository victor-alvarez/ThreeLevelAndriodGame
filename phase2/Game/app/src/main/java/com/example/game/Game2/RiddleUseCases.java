package com.example.game.Game2;

import com.example.game.BaseActivity;
import com.example.game.models.game2.RiddleListener;

import java.io.File;
import java.util.ArrayList;

public class RiddleUseCases {

    public void actOnCorrectness(String[] riddleStrings, String clickedString, RiddleListener riddleListener, File contextFile){
        for(int i = 0; i < 4; i++){
            if(riddleStrings[i + 2].equals(clickedString)){
                if(i == Integer.parseInt(riddleStrings[1])){
                    BaseActivity.account.incrementScore(5, contextFile);
                    riddleListener.rightAnswer();
                } else {
                    BaseActivity.account.decrementHitPoints(8, contextFile);
                    riddleListener.wrongAnswer();
                }
                return;
            }
        }
    }

    public void activateNextRiddle(ArrayList<Integer> remainingRiddles, RiddleListener riddleListener, File contextFile){
        if(BaseActivity.account.getHitPoints() <= 0){
            BaseActivity.account.incrementGamesPlayed(contextFile);
            riddleListener.noLivesLeft();
        } else if(remainingRiddles.size() == 0){
            BaseActivity.account.incrementGamesPlayed(contextFile);
            BaseActivity.account.incrementLevel(contextFile);
            riddleListener.endOfRiddles();
        } else {
            riddleListener.moreRiddles();
        }
    }
}
