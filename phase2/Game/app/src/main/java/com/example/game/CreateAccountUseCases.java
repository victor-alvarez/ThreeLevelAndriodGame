package com.example.game;

import android.content.Context;

import com.example.game.models.AccountManagerInterface;
import com.example.game.models.CreateAccountReactor;

import java.io.File;

/**
 * Performs the use cases of account creation
 */
public class CreateAccountUseCases {
    /**
     * Determines the existence of a users account on the system and creates new accounts
     */
    private AccountManagerInterface accountManager;

    /**
     * Creates a new CreateAccountUseCases and initializes the Account Manager
     */
    CreateAccountUseCases(AccountManagerInterface accountManager){
        this.accountManager = accountManager;
    }

    /**
     * Determines whether a username exists or does not exist (correct or incorrect).
     * @param username is the entered in username for an attempted login
     * @param contextFile the location of the application
     * @param createAccountReactor will react to whatever result is concluded from the return of
     *                     accountManager
     */
    void createAccount(final String username, File contextFile,
                       CreateAccountReactor createAccountReactor){
        Account account = accountManager.openExistingAccount(username, contextFile);
        if(account != null){
            createAccountReactor.accountCreationFailed();
        } else {
            accountManager.createNewAccount(username, contextFile);
            createAccountReactor.accountCreationSuccess();
        }
    }
}
