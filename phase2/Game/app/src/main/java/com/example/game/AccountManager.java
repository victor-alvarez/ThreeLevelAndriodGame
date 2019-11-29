package com.example.game;

import android.content.Context;

import com.example.game.models.AccountManagerInterface;

import java.io.File;

/**
 * Account manager that manages the creation and opening of accounts.
 */
class AccountManager implements AccountManagerInterface {

    /**
     * Creates new account with given login. Activates from Create Account button. Takes login from
     * Enter Login field. Uses default values for customization settings and save data. Creates save
     * file if missing.
     *
     * @param login of the Account.
     */
    @Override
    public void createNewAccount(String login, File contextFile) {
        AccountDataRepository.createNewAccount(login, contextFile);
    }

    /**
     * Creates account that was earlier saved to file. Activates from Select Account button. Takes
     * login from Enter Login field. Uses saved values for customization settings and save data.
     *
     * @param login of the Account.
     * @return Array[boolean][Account]: account found => loaded Account, save file or account
     * missing => null.
     */
    @Override
    public Account openExistingAccount(String login, File contextFile) {
        return AccountDataRepository.openExistingAccount(login, contextFile);
    }

    // Deletes all accounts
    void deleteAccountData(File contextFile) {
        AccountDataRepository.deleteAccountData(contextFile);
    }
}