package com.example.game.models;

import android.content.Context;

import com.example.game.Account;

public interface AccountManagerInterface {
    abstract void createNewAccount(String login, Context context);

    abstract Account openExistingAccount(String login, Context context);
}
