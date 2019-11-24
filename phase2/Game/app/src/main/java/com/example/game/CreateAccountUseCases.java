package com.example.game;

import android.content.Context;

import com.example.game.Domain.CreateAccountReactor;

/**
 * Performs the use cases of account creation
 */
public class CreateAccountUseCases {
    /**
     * Determines the existence of a users account on the system and creates new accounts
     */
    private AccountManager accountManager;

    /**
     * Creates a new CreateAccountUseCases and initializes the Account Manager
     */
    CreateAccountUseCases(){
        accountManager = new AccountManager();
    }

    /**
     * Determines whether a username exists or does not exist (correct or incorrect).
     * @param username is the entered in username for an attempted login
     * @param context the location of the application
     * @param createAccountReactor will react to whatever result is concluded from the return of
     *                     accountManager
     */
    void createAccount(final String username, Context context,
                       CreateAccountReactor createAccountReactor){
        Account account = accountManager.openExistingAccount(username, context);
        if(account != null){
            createAccountReactor.accountCreationFailed();
        } else {
            accountManager.createNewAccount(username, context);
            createAccountReactor.accountCreationSuccess();
        }
    }
}
