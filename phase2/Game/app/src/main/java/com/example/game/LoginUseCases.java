package com.example.game;

import android.content.Context;

import com.example.game.Domain.LoginReactor;

/**
 * Class which performs the use cases for logging in with accounts.
 */
class LoginUseCases {
    private AccountManager accountManager;

    LoginUseCases(){
        accountManager = new AccountManager();
    }

    /**
     * Determines whether a username exists or does not exist (correct or incorrect).
     * @param username is the entered in username for an attempted login
     * @param context the location of the application
     * @param loginReactor will react to whatever result is concluded from the return of
     *                     accountManager
     */
    void login(final String username, Context context,
                      LoginReactor loginReactor){
        Account account = accountManager.openExistingAccount(username, context);
        if(account != null){
            loginReactor.correctUsername(account);
        } else {
            loginReactor.incorrectUsername();
        }
    }
}
