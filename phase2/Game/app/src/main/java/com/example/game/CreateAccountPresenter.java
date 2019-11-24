package com.example.game;

import android.content.Context;

import com.example.game.Domain.CreateAccountActions;
import com.example.game.Domain.CreateAccountReactor;

/**
 * Presenter layer for account creations which communicates between the UI and Use Cases.
 */
public class CreateAccountPresenter implements CreateAccountReactor {
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
    CreateAccountPresenter(CreateAccountActions createAccountActions,
                           CreateAccountUseCases createAccountUseCases){
        this.createAccountActions = createAccountActions;
        this.createAccountUseCases = createAccountUseCases;
    }

    /**
     * Tells the use cases to check over this login.
     * @param username the entered in username for this login
     * @param context the location of the application
     */
    void createAccount(String username, Context context){
        createAccountUseCases.createAccount(username, context, this);
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
