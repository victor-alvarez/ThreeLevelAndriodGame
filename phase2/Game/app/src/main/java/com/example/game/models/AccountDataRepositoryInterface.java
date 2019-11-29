package com.example.game.models;

import com.example.game.Account;

import java.io.File;

/**
 *
 */
public interface AccountDataRepositoryInterface {
    void save(File contextFile, Account account);

    void createNewAccount(String login, File contextFile);

    Account openExistingAccount(String login, File contextFile);

    void deleteAccountData(File contextFile);
}
