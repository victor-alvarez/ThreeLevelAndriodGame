package com.example.game.models.game2.Interfaces;

/**
 * The actions that the view-level of the riddle game should be able to take.
 */
public interface RiddleActions {
    void wrongAnswer();

    void rightAnswer();

    void finishRiddles();

    void setNewRiddleText();

    void noLivesLeft();
}
