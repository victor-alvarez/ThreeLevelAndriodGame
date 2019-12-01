package com.example.game.models;

import java.io.File;

/**
 * Interface for whatever service/class accesses the database directly
 */
public interface AccountDataRepositoryInterface {
    void save(File contextFile, Account account);

    void createNewAccount(String login, File contextFile);

    Account openExistingAccount(String login, File contextFile);

    void deleteAccountData(File contextFile);
}
