package com.example.game.models;

import com.example.game.models.Interfaces.LoadGameListener;

import java.io.File;

import static com.example.game.BaseActivity.account;

public class MainLoadUseCases {
    /**
     * Performs actions related to starting the first game
     * @param contextFile the file the database is saved at
     */
    public void game1(LoadGameListener listener, File contextFile) {
        account.resetValues(contextFile);
        listener.directToGame1();
    }

    /**
     * Performs actions related to starting the second game
     * @param contextFile the file the database is saved at
     */
    public void game2(LoadGameListener listener, File contextFile) {
        while (account.getLastAttemptedLevel() != 2){
            account.incrementLevel(contextFile);
        }
        listener.directToGame2();
    }

    /**
     * Performs actions related to starting the third game
     * @param contextFile the file the database is saved at
     */
    public void game3(LoadGameListener listener, File contextFile) {
        while (account.getLastAttemptedLevel() != 3){
            account.incrementLevel(contextFile);
        }
        listener.directToGame3();
    }

    /**
     * Performs actions related to resuming the game
     * @param contextFile the file the database is saved at
     */
    public void resume(LoadGameListener listener, File contextFile){
        int level = account.getLastAttemptedLevel();

        switch (level){
            case 0:
                listener.directToGame1();
                break;
            case 1:
                listener.directToAfterGame1();
                break;
            case 2:
                listener.directToGame2();
                break;
            case 3:
                listener.directToGame3();
                break;
            case 4:
                listener.directToAfterGame3();
                break;
        }
    }
}
