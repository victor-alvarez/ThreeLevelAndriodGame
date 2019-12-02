package com.example.game.presenters;

import com.example.game.models.CreateAccountUseCases;
import com.example.game.models.interfaces.CreateAccountActions;
import com.example.game.models.interfaces.CreateAccountListener;

import java.io.File;

/**
 * Presenter layer for account creations which communicates between the UI and Use Cases.
 */
public class CreateAccountPresenter implements CreateAccountListener {
    /**
     * UI which this presenter interacts with.
     */
    private CreateAccountActions createAccountActions;

    /**
     * Use cases which directly interact with information.
     */
    private CreateAccountUseCases createAccountUseCases;

    /**
     * Creates a new CreateAccountPresenter
     * @param createAccountActions actions which the UI can perform
     * @param createAccountUseCases interacts directly with the data
     */
    public CreateAccountPresenter(CreateAccountActions createAccountActions,
                           CreateAccountUseCases createAccountUseCases){
        this.createAccountActions = createAccountActions;
        this.createAccountUseCases = createAccountUseCases;
    }

    /**
     * Tells the use cases to check over this login.
     * @param username the entered in username for this login
     * @param contextFile the location of the application
     */
    public void createAccount(String username, File contextFile){
        createAccountUseCases.createAccount(username, contextFile, this);
    }

    /**
     * Actions when account creation has failed.
     */
    @Override
    public void accountCreationFailed() {
        createAccountActions.accountCreationFailed();
    }

    /**
     * Actions on account creation success.
     */
    @Override
    public void accountCreationSuccess() {
        createAccountActions.accountCreationSuccess();
    }
}
