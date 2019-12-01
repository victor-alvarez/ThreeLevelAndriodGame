package com.example.game.models.game2.Interfaces;

/**
 * What actions the class listening to the results of the use cases of the riddles should be able to
 * take.
 */
public interface RiddleListener {
    void rightAnswer();

    void wrongAnswer();

    void endOfRiddles();

    void moreRiddles();

    void noLivesLeft();
}
