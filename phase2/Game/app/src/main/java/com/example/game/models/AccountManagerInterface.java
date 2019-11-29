package com.example.game.models;

import android.content.Context;

import com.example.game.Account;

import java.io.File;

public interface AccountManagerInterface {
    abstract void createNewAccount(String login, File contextFile);

    abstract Account openExistingAccount(String login, File contextFile);
}
