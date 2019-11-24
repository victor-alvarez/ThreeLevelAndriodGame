package com.example.game;

import android.content.Context;

import com.example.game.Domain.LoginActions;
import com.example.game.Domain.LoginReactor;

/**
 * Presenter for LoginActivity. It communicates with LoginActivity to determine actions related
 * to logging in.
 */
public class LoginPresenter implements LoginReactor {

    /**
     * UI which this presenter interacts with.
     */
    private LoginActions loginActions;

    /**
     * Use cases which directly interact with information.
     */
    private LoginUseCases loginUseCases;

    LoginPresenter(LoginActions loginActions, LoginUseCases loginUseCases){
        this.loginActions = loginActions;
        this.loginUseCases = loginUseCases;
    }


    @Override
    public void incorrectUsername() {
        loginActions.incorrectUsername();
    }

    @Override
    public void correctUsername(Account account) {
        loginActions.moveToMainMenu(account);
    }

    /**
     * Tells the use cases to check over this login.
     * @param username the entered in username for this login
     * @param context the location of the application
     */
    void login(String username, Context context){
        loginUseCases.login(username, context, this);
    }
}
