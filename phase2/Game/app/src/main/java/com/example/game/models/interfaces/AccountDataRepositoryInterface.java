package com.example.game.models.interfaces;

import com.example.game.models.Account;

import java.io.File;

/**
 * Interface for whatever service/class accesses the database directly for account information
 */
public interface AccountDataRepositoryInterface {
    void save(File contextFile, Account account);

    void createNewAccount(String login, File contextFile);

    Account openExistingAccount(String login, File contextFile);

    void deleteAccountData(File contextFile);
}
