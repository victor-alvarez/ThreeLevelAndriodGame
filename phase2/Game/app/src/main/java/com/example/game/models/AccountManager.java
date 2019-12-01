package com.example.game.models;

import com.example.game.models.Account;
import com.example.game.models.AccountDataRepositoryInterface;
import com.example.game.models.AccountManagerInterface;

import java.io.File;

/**
 * Account manager that manages the creation and opening of accounts
 */
public class AccountManager implements AccountManagerInterface {

    /**
     * Object which accesses and edits the database.
     */
    private AccountDataRepositoryInterface accountDataRepository;

    /**
     * Instantiates and returns a new AccountManager
     * @param accountDataRepositoryInterface the object used to edit and recieve information from
     *                                       the database.
     */
    public AccountManager(AccountDataRepositoryInterface accountDataRepositoryInterface){
        accountDataRepository = accountDataRepositoryInterface;
    }

    /**
     * Creates new account with given login. Activates from Create Account button. Takes login from
     * Enter Login field. Uses default values for customization settings and save data. Creates save
     * file if missing.
     *
     * @param login of the Account.
     * @param contextFile the file in which the database is located
     */
    @Override
    public void createNewAccount(String login, File contextFile) {
        accountDataRepository.createNewAccount(login, contextFile);
    }

    /**
     * Creates account that was earlier saved to file. Activates from Select Account button. Takes
     * login from Enter Login field. Uses saved values for customization settings and save data.
     *
     * @param login of the Account.
     * @param contextFile the file in which the database is located
     * @return Array[boolean][Account]: account found => loaded Account, save file or account
     * missing => null.
     */
    @Override
    public Account openExistingAccount(String login, File contextFile) {
        return accountDataRepository.openExistingAccount(login, contextFile);
    }

    /** Deletes all accounts
     * @param contextFile the file in which the database is located
     */
    public void deleteAccountData(File contextFile) {
        accountDataRepository.deleteAccountData(contextFile);
    }
}