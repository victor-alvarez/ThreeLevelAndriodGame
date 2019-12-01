package com.example.game.presenters;

import com.example.game.models.Interfaces.LoadGameActions;
import com.example.game.models.Interfaces.LoadGameListener;
import com.example.game.models.MainLoadUseCases;

import java.io.File;

/**
 * Interacts between the class which loads the games and its use cases.
 */
public class MainLoadPresenter implements LoadGameListener {

    /**
     * The the class which loads the game.
     */
    private LoadGameActions loadGameActions;

    /**
     * The use case class.
     */
    private MainLoadUseCases mainLoadUseCases;

    public MainLoadPresenter(LoadGameActions loadGameActions, MainLoadUseCases mainLoadUseCases){
        this.loadGameActions = loadGameActions;
        this.mainLoadUseCases = mainLoadUseCases;
    }

    /**
     * Delegates performing actions related to starting the first game to the Model
     * @param contextFile the file the database is saved at
     */
    public void game1(File contextFile) {
        mainLoadUseCases.game1(this, contextFile);
    }

    /**
     * Delegates performing actions related to starting the second game to the Model
     * @param contextFile the file the database is saved at
     */
    public void game2(File contextFile) {
        mainLoadUseCases.game2(this, contextFile);
    }

    /**
     * Delegates performing actions related to starting the third game to the Model
     * @param contextFile the file the database is saved at
     */
    public void game3(File contextFile) {
        mainLoadUseCases.game3(this, contextFile);
    }

    /**
     * Delegates performing actions related to resuming the game to the Model
     * @param contextFile the file the database is saved at
     */
    public void resume(File contextFile){
        mainLoadUseCases.resume(this, contextFile);
    }

    @Override
    public void directToGame1() {
        loadGameActions.toGame1();
    }

    @Override
    public void directToGame2() {
        loadGameActions.toGame2();
    }

    @Override
    public void directToGame3() {
        loadGameActions.toGame3();
    }

    @Override
    public void directToAfterGame1(){
        loadGameActions.toAfterGame1();
    }

    @Override
    public void directToAfterGame3() {
        loadGameActions.toAfterGame3();
    }
}
