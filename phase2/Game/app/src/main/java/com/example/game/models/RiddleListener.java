package com.example.game.models;

public interface RiddleListener {
    void rightAnswer();

    void wrongAnswer();

    void endOfRiddles();

    void moreRiddles();
}
