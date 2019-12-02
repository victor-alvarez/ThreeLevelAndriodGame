package com.example.game.models.game2;

import com.example.game.BaseActivity;
import com.example.game.models.game2.Interfaces.RiddleListener;

import java.io.File;
import java.util.ArrayList;

/**
 * Use cases for answering multiple choice riddles
 */
public class RiddleUseCases {

    /**
     * Determines whether the clicked answer is right or wrong, updates account information, and
     * tells the listener to react accordingly.
     *
     * @param riddleStrings  The array containing all answers to the riddle and which answer is
     *                       correct
     * @param clickedString  the String for the riddle which was clicked on (selected)
     * @param riddleListener the listener which reacts to the result of a right or wrong answer
     * @param contextFile    the File which any changed data will be saved to
     */
    public void actOnCorrectness(String[] riddleStrings, String clickedString,
                                 RiddleListener riddleListener, File contextFile) {
        for (int i = 0; i < 4; i++) {
            if (riddleStrings[i + 2].equals(clickedString)) {
                if (i == Integer.parseInt(riddleStrings[1])) {
                    BaseActivity.account.incrementScore(5, contextFile);
                    riddleListener.rightAnswer();
                } else {
                    BaseActivity.account.decrementHitPoints(8, contextFile);
                    riddleListener.wrongAnswer();
                }
            }
        }
    }

    /**
     * Sends player to game over screen if they have no hit points left, or sends them to the end
     * of the game or the next riddle depending on how many riddles are left if they still have hit
     * points left.
     *
     * @param remainingRiddles the list of remaining riddles numbers
     * @param riddleListener   the listener which reacts to the result of a right or wrong answer
     * @param contextFile      the File which any changed data will be saved to
     */
    public void activateNextRiddle(ArrayList<Integer> remainingRiddles, RiddleListener riddleListener, File contextFile) {
        if (BaseActivity.account.getHitPoints() <= 0) {
            BaseActivity.account.incrementGamesPlayed(contextFile);
            riddleListener.noLivesLeft();
        } else if (remainingRiddles.size() == 0) {
            BaseActivity.account.incrementGamesPlayed(contextFile);
            BaseActivity.account.incrementLevel(contextFile);
            riddleListener.endOfRiddles();
        } else {
            riddleListener.moreRiddles();
        }
    }
}
