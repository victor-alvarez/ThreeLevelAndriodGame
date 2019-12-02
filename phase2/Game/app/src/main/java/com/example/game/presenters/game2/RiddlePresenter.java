package com.example.game.presenters.game2;

import com.example.game.models.game2.Interfaces.RiddleActions;
import com.example.game.models.game2.Interfaces.RiddleListener;
import com.example.game.models.game2.RiddleUseCases;

import java.io.File;
import java.util.ArrayList;

/**
 * The presenter for the Riddle game. It communicates between the View and the Model.
 */
public class RiddlePresenter implements RiddleListener {

    /**
     * The actions that the view can take.
     */
    private RiddleActions riddleActions;

    /**
     * The use cases of the riddle.
     */
    private RiddleUseCases riddleUseCases;

    /**
     * Instantiates a new RiddlePresenter and returns it.
     * @param riddleActions and instantiate-able instance of RiddleActions. Most likely the View.
     * @param riddleUseCases an instance of the use cases of the riddle game.
     */
    public RiddlePresenter (RiddleActions riddleActions, RiddleUseCases riddleUseCases){
        this.riddleActions = riddleActions;
        this.riddleUseCases = riddleUseCases;
    }

    /**
     * Delegates determining and reacting to right and wrong answers to the use cases.
     * @param riddleStrings The array containing all answers to the riddle and which answer is
     *                      correct
     * @param clickedString the String for the riddle which was clicked on (selected)
     * @param contextFile the File which any changed data will be saved to
     */
    public void determineRightOrWrong(String[] riddleStrings, String clickedString, File contextFile){
        riddleUseCases.actOnCorrectness(riddleStrings, clickedString, this, contextFile);
    }

    /**
     *
     * @param remainingRiddles the list of remaining riddles numbers
     * @param contextFile the File which any changed data will be saved to
     */
    public void nextRiddle(ArrayList<Integer> remainingRiddles, File contextFile){
        riddleUseCases.activateNextRiddle(remainingRiddles, this, contextFile);
    }

    /**
     * Tell riddleActions to finish the riddle game.
     */
    @Override
    public void endOfRiddles(){
        riddleActions.finishRiddles();
    }

    /**
     * Tell riddleActions to do what is needed for a right answer.
     */
    @Override
    public void rightAnswer(){
        riddleActions.rightAnswer();
    }

    /**
     * Tell riddleActions to do what is needed for a wrong answer.
     */
    @Override
    public void wrongAnswer(){
        riddleActions.wrongAnswer();
    }

    /**
     * Tell riddleActions to do more riddles.
     */
    @Override
    public void moreRiddles(){
        riddleActions.setNewRiddleText();
    }

    /**
     * Tell riddleActions to do what needs to be done if no lives are left.
     */
    @Override
    public void noLivesLeft() {
        riddleActions.noLivesLeft();
    }
}
