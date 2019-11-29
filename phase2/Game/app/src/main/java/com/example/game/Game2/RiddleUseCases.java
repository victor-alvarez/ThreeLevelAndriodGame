package com.example.game.Game2;

import com.example.game.models.game2.RiddleListener;

import java.util.ArrayList;

public class RiddleUseCases {

    public void actOnCorrectness(String[] riddleStrings, String clickedString, RiddleListener riddleListener){
        for(int i = 0; i < 4; i++){
            if(riddleStrings[i + 2].equals(clickedString)){
                if(i == Integer.parseInt(riddleStrings[1])){
                    riddleListener.rightAnswer();
                } else {
                    riddleListener.wrongAnswer();
                }
                return;
            }
        }
    }

    public void activateNextRiddle(ArrayList<Integer> remainingRiddles, RiddleListener riddleListener){
        if(remainingRiddles.size() == 0){
            riddleListener.endOfRiddles();
        } else {
            riddleListener.moreRiddles();
        }
    }
}
