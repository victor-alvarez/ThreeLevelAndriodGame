package com.example.game;

import android.content.Context;

import com.example.game.models.AccountDataRepositoryInterface;
import com.example.game.models.AccountManagerInterface;
import com.example.game.models.LoginListener;

import java.io.File;

/**
 * Class which performs the use cases for logging in with accounts
 */
class LoginUseCases {
    private AccountManagerInterface accountManager;

    LoginUseCases(AccountManagerInterface accountManager){
        this.accountManager = accountManager;
    }

    /**
     * Determines whether a username exists or does not exist (correct or incorrect).
     * @param username is the entered in username for an attempted login
     * @param contextFile the location of the application
     * @param loginReactor will react to whatever result is concluded from the return of
     *                     accountManager
     * @param accountDataRepository the interface which accesses the database
     */
    void login(final String username, File contextFile,
               LoginListener loginReactor, AccountDataRepositoryInterface accountDataRepository){
        Account account = accountManager.openExistingAccount(username, contextFile);
        if(account != null){
            AccountHolder accountHolder = new AccountHolder(account, accountDataRepository);
            loginReactor.correctUsername(accountHolder);
        } else {
            loginReactor.incorrectUsername();
        }
    }
}
