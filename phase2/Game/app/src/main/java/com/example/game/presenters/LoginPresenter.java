package com.example.game.presenters;

import com.example.game.models.LoginUseCases;
import com.example.game.models.interfaces.AccountDataRepositoryInterface;
import com.example.game.models.AccountHolder;
import com.example.game.models.interfaces.LoginActions;
import com.example.game.models.interfaces.LoginListener;

import java.io.File;

/**
 * Presenter for LoginActivity. It communicates with LoginActivity to determine actions related
 * to logging in.
 */
public class LoginPresenter implements LoginListener {

    /**
     * UI which this presenter interacts with.
     */
    private LoginActions loginActions;

    /**
     * Use cases which directly interact with information.
     */
    private LoginUseCases loginUseCases;

    public LoginPresenter(LoginActions loginActions, LoginUseCases loginUseCases){
        this.loginActions = loginActions;
        this.loginUseCases = loginUseCases;
    }


    @Override
    public void incorrectUsername() {
        loginActions.incorrectUsername();
    }

    @Override
    public void correctUsername(AccountHolder accountHolder) {
        loginActions.moveToMainMenu(accountHolder);
    }

    /**
     * Tells the use cases to check over this login
     * @param username the entered in username for this login
     * @param contextFile the location of the application
     * @param accountDataRepository the interface which accesses the database
     */
    public void login(String username, File contextFile, AccountDataRepositoryInterface accountDataRepository){
        loginUseCases.login(username, contextFile, this, accountDataRepository);
    }
}
